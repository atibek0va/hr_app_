package com.example.hrapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hrapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditUserInfo extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    ImageView btnBack, line, editPhoto;
    Button btnSave, btnCancel;
    LinearLayout ll10, ll11;
    EditText editHour, editCuratorship, editAddWorks, editInsta, editTele, editMail, editPhone;
    TextView personInfo;

    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;

    Animation from_bottom, from_top, from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);
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

        toolbar = findViewById(R.id.profile_tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        line = findViewById(R.id.line);
        editPhoto = findViewById(R.id.editPhoto);

        ll10 = findViewById(R.id.linearLayout10);
        ll11 = findViewById(R.id.linearLayout11);

        editHour = findViewById(R.id.editHour);
        editCuratorship = findViewById(R.id.editCuratorship);
        editAddWorks = findViewById(R.id.editAddWorks);

        editInsta = findViewById(R.id.editInsta);
        editTele = findViewById(R.id.editTele);
        editMail = findViewById(R.id.editMail);
        editPhone = findViewById(R.id.editPhone);

        btnBack = findViewById(R.id.back);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        personInfo = findViewById(R.id.personInfo);

        btnSave.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        toolbar.setAnimation(from_left);
        line.setAnimation(from_right);
        editPhoto.setAnimation(from_right);
        ll10.setAnimation(from_left);
        ll11.setAnimation(from_left);
        editHour.setAnimation(from_right);
        editCuratorship.setAnimation(from_right);
        editAddWorks.setAnimation(from_right);
        editInsta.setAnimation(from_right);
        editTele.setAnimation(from_right);
        editMail.setAnimation(from_right);
        editPhone.setAnimation(from_right);
        btnSave.setAnimation(from_bottom);
        btnCancel.setAnimation(from_bottom);
        personInfo.setAnimation(from_right);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSave){
            saveInfo();
            startActivity(new Intent(EditUserInfo.this, ProfileActivity.class));
        }else if(v.getId() == R.id.btnCancel){
            startActivity(new Intent(EditUserInfo.this, ProfileActivity.class));
        }else if (v.getId() == R.id.back){
            startActivity(new Intent(EditUserInfo.this, ProfileActivity.class));
        }
    }

    public void saveInfo(){
        String uhour = editHour.getText().toString();
        String ucurator = editCuratorship.getText().toString();
        String uaddWorks = editAddWorks.getText().toString();
        String uinsta = editInsta.getText().toString();
        String utele = editTele.getText().toString();
        String umail = editMail.getText().toString();
        String uphone = editPhone.getText().toString();

        userCurrentEmail = auth.getCurrentUser().getEmail().replace(".", "-");

        myRef.child("users").child(userCurrentEmail).child("employeeAddworks").setValue(uaddWorks);
        myRef.child("users").child(userCurrentEmail).child("employeeCuratorship").setValue(ucurator);
        myRef.child("users").child(userCurrentEmail).child("employeeWorkingHour").setValue(uhour);
        myRef.child("users").child(userCurrentEmail).child("insta").setValue(uinsta);
        myRef.child("users").child(userCurrentEmail).child("employeeEmail").setValue(umail);
        myRef.child("users").child(userCurrentEmail).child("employeeNumber").setValue(uphone);
        myRef.child("users").child(userCurrentEmail).child("tele").setValue(utele);
    }
}