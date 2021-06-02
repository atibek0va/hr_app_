package com.example.hrapp.activities.guest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hrapp.R;
import com.example.hrapp.activities.ProfileActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ApplyActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView btnBack;
    Button btnSave, btnCancel;
    LinearLayout ll10;
    EditText editHour, editCuratorship, editAddWorks, editInsta;
    TextView personInfo;

    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;

    Animation from_bottom, from_top, from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        initViews();
        setAnimation();

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
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);

        ll10 = findViewById(R.id.linearLayout10);

        editHour = findViewById(R.id.editHour);
        editCuratorship = findViewById(R.id.editCuratorship);
        editAddWorks = findViewById(R.id.editAddWorks);
        editInsta = findViewById(R.id.editAddWorkss);

        btnBack = findViewById(R.id.back);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        personInfo = findViewById(R.id.personInfo);

        btnSave.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        toolbar.setAnimation(from_left);
        ll10.setAnimation(from_left);
        editHour.setAnimation(from_right);
        editCuratorship.setAnimation(from_right);
        editAddWorks.setAnimation(from_right);
        btnSave.setAnimation(from_bottom);
        btnCancel.setAnimation(from_bottom);
        personInfo.setAnimation(from_right);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSave){
            saveInfo();
            startActivity(new Intent(ApplyActivity.this, JobDescriptionActivity.class));
        }else if(v.getId() == R.id.btnCancel){
            startActivity(new Intent(ApplyActivity.this, JobDescriptionActivity.class));
        }else if (v.getId() == R.id.back){
            startActivity(new Intent(ApplyActivity.this, JobDescriptionActivity.class));
        }
    }

    public void saveInfo(){
        String uname = editHour.getText().toString();
        String uemail = editCuratorship.getText().toString();
        String unumber = editAddWorks.getText().toString();
        String uresume = editInsta.getText().toString();


//        myRef.child("appliers").child(uname).child("full name").setValue(uname);
        myRef.child("appliers").child(uname).child("email").setValue(uemail);
        myRef.child("appliers").child(uname).child("phone number").setValue(unumber);
        myRef.child("appliers").child(uname).child("cv").setValue(uresume);
    }
}