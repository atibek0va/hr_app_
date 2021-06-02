package com.example.hrapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hrapp.R;
import com.example.hrapp.adapter.DoctorAdapter;
import com.example.hrapp.fragment.PsychFragment;
import com.example.hrapp.model.Doctor;

import java.util.ArrayList;

public class Doctors extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView btnBack;
    RecyclerView recyclerView;
    DoctorAdapter doctorAdapter;
    ArrayList<Doctor> doctorList;
    private RecyclerView.LayoutManager linearLayoutManager;

    Animation from_bottom,from_top,  from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        initViews();
        getDoctor();
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

        btnBack = findViewById(R.id.back);

        btnBack.setOnClickListener(this);

        recyclerView = findViewById(R.id.recycler);
        doctorList = new ArrayList<>();
        doctorAdapter = new DoctorAdapter(this, doctorList);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(doctorAdapter);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        toolbar.setAnimation(from_left);
        recyclerView.setAnimation(from_right);
    }

    public void getDoctor(){
        doctorList.add(new Doctor(R.drawable.doctor1, "Ms.Azaliya", "Work experience: 6 years", "+7 708 419 54 22"));
        doctorList.add(new Doctor(R.drawable.doctor2,"Mr.Turlibaev", "Work experience: 4 years", "+7 708 419 54 22"));
        doctorList.add(new Doctor(R.drawable.doctor3, "Ms.Naily", "Work experience: 3 years", "+7 708 419 54 22"));
        doctorList.add(new Doctor(R.drawable.doctor4, "Mr.Madibee", "Work experience: 5 years", "+7 708 419 54 22"));
        doctorAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back){
            startActivity(new Intent(Doctors.this, MainPageActivity.class));
        }
    }
}