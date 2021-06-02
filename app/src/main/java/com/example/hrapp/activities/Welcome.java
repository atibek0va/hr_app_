package com.example.hrapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hrapp.R;
import com.example.hrapp.activities.guest.GuestMainPageActivity;
import com.example.hrapp.activities.guest.WelcomeGuestActivity;
import com.example.hrapp.authenfication.Login;

public class Welcome extends AppCompatActivity {

    Button employee, guest;
    TextView tvWelcome;
    LinearLayout logo;

    Animation from_bottom, from_top, from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initViews();
        setAnimation();
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
        employee = findViewById(R.id.employee);
        guest = findViewById(R.id.guest);

        tvWelcome = findViewById(R.id.tvWelcome);

        logo = findViewById(R.id.logo);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        logo.setAnimation(from_top);
        tvWelcome.setAnimation(from_left);
        employee.setAnimation(from_bottom);
        guest.setAnimation(from_bottom);
    }

    public void onClicked(){
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, Login.class));
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome.this, WelcomeGuestActivity.class));
            }
        });
    }
}