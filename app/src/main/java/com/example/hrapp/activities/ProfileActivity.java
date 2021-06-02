package com.example.hrapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hrapp.R;
import com.example.hrapp.model.Employee;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView btnBack;
    ImageView editUserInfo, profile_img;
    TextView userName, userMamandyk, workingHour, curatorship, addWorks, personInfo, tv1, tv2, tv3;
    LinearLayout layoutMonthly, networks;

    FirebaseAuth auth;
    DatabaseReference databaseReference;
    String userCurrent;
    Employee userm;

    Animation from_bottom, from_top, from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        setAnimation();
        user_info();
        onClicked();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        );
    }
    public void initViews(){
        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        toolbar = findViewById(R.id.profile_tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        layoutMonthly = findViewById(R.id.layoutMonthly);
        networks = findViewById(R.id.networks);

        btnBack = findViewById(R.id.back);
        editUserInfo = findViewById(R.id.editUserInfo);
        profile_img = findViewById(R.id.profile_img);

        userName = findViewById(R.id.userName);
        userMamandyk = findViewById(R.id.userMamandyk);
        workingHour = findViewById(R.id.workingHour);
        curatorship = findViewById(R.id.curatorship);
        addWorks = findViewById(R.id.addWorks);
        personInfo = findViewById(R.id.personInfo);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        toolbar.setAnimation(from_left);
        profile_img.setAnimation(from_top);
        userMamandyk.setAnimation(from_top);
        userName.setAnimation(from_top);
        networks.setAnimation(from_top);
        personInfo.setAnimation(from_bottom);
        editUserInfo.setAnimation(from_bottom);
        layoutMonthly.setAnimation(from_bottom);
        workingHour.setAnimation(from_bottom);
        curatorship.setAnimation(from_bottom);
        addWorks.setAnimation(from_bottom);
        tv1.setAnimation(from_bottom);
        tv2.setAnimation(from_bottom);
        tv3.setAnimation(from_bottom);
    }

    public void user_info(){
        userCurrent = auth.getCurrentUser().getEmail().replace(".", "-");
        Log.i("currentUser", userCurrent);

        getInfo(userCurrent);
    }

    private void getInfo(String userCurrent) {
        databaseReference.child("users").child(userCurrent).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userm = snapshot.getValue(Employee.class);
                userName.setText(userm.getEmployeeName());
                userMamandyk.setText(userm.getEmployeeSpecial());
                workingHour.setText(userm.getEmployeeWorkingHour());
                curatorship.setText(userm.getEmployeeCuratorship());
                addWorks.setText(userm.getEmployeeAddworks());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void onClicked(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainPageActivity.class));
            }
        });
        editUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, EditUserInfo.class));
            }
        });
        layoutMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdActivity = new Intent(ProfileActivity.this, StatisticsActivity.class);
                startActivity(thirdActivity);
            }
        });
    }
}