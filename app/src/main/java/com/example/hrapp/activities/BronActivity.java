package com.example.hrapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.hrapp.R;
import com.example.hrapp.fragment.PsychFragment;
import com.google.android.material.textfield.TextInputEditText;

public class BronActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton showList, hideList;
    Button btnBooking, time, time1, time2, time3, time4, time5, time6, time7, time8, time9, time10, time11;
    LinearLayout llayout, day, day1, day2, day3, day4;
    TextInputEditText feeling;
    Toolbar toolbar;
    ImageView btnBack, doctor_photo;
    ScrollView scroll;


    Animation from_bottom,from_top,  from_right, from_left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bron);
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
        doctor_photo = findViewById(R.id.ph);
        showList = findViewById(R.id.showList);
        hideList = findViewById(R.id.hideList);
        llayout = findViewById(R.id.llayout);
        scroll = findViewById(R.id.scroll);

        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnBack = findViewById(R.id.back);
        btnBooking = findViewById(R.id.btnBooking);

        day = findViewById(R.id.day);
        day1 = findViewById(R.id.day1);
        day2 = findViewById(R.id.day2);
        day3 = findViewById(R.id.day3);
        day4 = findViewById(R.id.day4);

        time = findViewById(R.id.time);
        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        time3 = findViewById(R.id.time3);
        time4 = findViewById(R.id.time4);
        time5 = findViewById(R.id.time5);
        time6 = findViewById(R.id.time6);
        time7 = findViewById(R.id.time7);
        time8 = findViewById(R.id.time8);
        time9 = findViewById(R.id.time9);
        time10 = findViewById(R.id.time10);
        time11 = findViewById(R.id.time11);

        feeling = findViewById(R.id.feeling);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);

        btnBack.setOnClickListener(this);
        btnBooking.setOnClickListener(this);
        showList.setOnClickListener(this);
        hideList.setOnClickListener(this);

        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time1.setBackgroundColor(Color.BLACK);
            }
        });
    }

    public void setAnimation(){
        toolbar.setAnimation(from_left);
        scroll.setAnimation(from_right);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.showList){
            llayout.setVisibility(View.VISIBLE);
            showList.setVisibility(View.INVISIBLE);
        }else if (v.getId() == R.id.hideList){
            llayout.setVisibility(View.INVISIBLE);
            showList.setVisibility(View.VISIBLE);
        }else if (v.getId() == R.id.back){
            startActivity(new Intent(BronActivity.this, Doctors.class));
        }
    }
}