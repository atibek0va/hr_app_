package com.example.hrapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hrapp.R;
import com.example.hrapp.model.Complaint;
import com.example.hrapp.model.Question;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewComplaintActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView btnBack;
    Button btnSubmit, btnCancel;
    TextInputEditText inputComplaint, inputDate;

    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;

    Animation from_bottom, from_top, from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_complaint);
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

        toolbar = findViewById(R.id.tb_question);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        inputComplaint = findViewById(R.id.inputComplaint);
        inputDate = findViewById(R.id.inputDate);

        btnBack = findViewById(R.id.back);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        btnSubmit.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        toolbar.setAnimation(from_left);
        inputComplaint.setAnimation(from_bottom);
        inputDate.setAnimation(from_bottom);
        btnSubmit.setAnimation(from_bottom);
        btnCancel.setAnimation(from_bottom);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSubmit){
            saveInfo();
            startActivity(new Intent(NewComplaintActivity.this, MainPageActivity.class));
        }else if(v.getId() == R.id.btnCancel){
            startActivity(new Intent(NewComplaintActivity.this, MainPageActivity.class));
        }else if (v.getId() == R.id.back){
            startActivity(new Intent(NewComplaintActivity.this, MainPageActivity.class));
        }
    }

    public void saveInfo(){
        String ucomplaint = inputComplaint.getText().toString();
        String udate = inputDate.getText().toString();
        String user = auth.getCurrentUser().getEmail();

        userCurrentEmail = auth.getCurrentUser().getEmail().replace(".", "-");

        Complaint complaint = new Complaint(ucomplaint, udate, user);

        myRef.child("complaints").child(complaint.getDate()).setValue(complaint);
    }
}