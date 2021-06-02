package com.example.hrapp.activities.guest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hrapp.R;
import com.example.hrapp.activities.Doctors;
import com.example.hrapp.adapter.DoctorAdapter;
import com.example.hrapp.fragment.JobsFragment;
import com.example.hrapp.fragment.PsychFragment;

import java.util.ArrayList;

public class JobDescriptionActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView btnBack;
    Button btnApply;

    TextView jobTitle, jobSalary, jobTime, desc, desc_text, pref, pref_text;

    Animation from_bottom,from_top,  from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_description);
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
        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        jobTitle = findViewById(R.id.jobTitle);
        jobSalary = findViewById(R.id.jobSalary);
        jobTime = findViewById(R.id.jobTime);

        desc = findViewById(R.id.desc);
        desc_text = findViewById(R.id.desc_text);
        pref = findViewById(R.id.pref);
        pref_text = findViewById(R.id.pref_text);

        btnBack = findViewById(R.id.back);
        btnApply = findViewById(R.id.btnApply);

        btnBack.setOnClickListener(this);
        btnApply.setOnClickListener(this);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        toolbar.setAnimation(from_left);
        jobTitle.setAnimation(from_right);
        jobSalary.setAnimation(from_left);
        jobTime.setAnimation(from_right);
        desc.setAnimation(from_left);
        pref.setAnimation(from_left);
        desc_text.setAnimation(from_right);
        pref_text.setAnimation(from_right);
        btnApply.setAnimation(from_bottom);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back){
            startActivity(new Intent(JobDescriptionActivity.this, JobsFragment.class));
        }else if (v.getId() == R.id.btnApply){
            startActivity(new Intent(JobDescriptionActivity.this, ApplyActivity.class));
        }
    }
}