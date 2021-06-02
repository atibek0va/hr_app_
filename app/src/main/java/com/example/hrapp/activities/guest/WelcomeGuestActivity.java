package com.example.hrapp.activities.guest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hrapp.R;
import com.example.hrapp.fragment.FinanceFragment;
import com.example.hrapp.fragment.HomeFragment;
import com.example.hrapp.fragment.PsychFragment;
import com.example.hrapp.fragment.QuestionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WelcomeGuestActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView sloganimg, figthing;
    ImageButton nxtPage;
    TextView slogan;
    LinearLayout logo, jobs, customers;

    Animation from_bottom, from_top, from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_guest);
        initViews();
        setAnimation();
        onCLicked();

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
        toolbar = findViewById(R.id.main_tb);
        setSupportActionBar(toolbar);

        sloganimg = findViewById(R.id.sloganimg);
        figthing = findViewById(R.id.fighting);

        slogan = findViewById(R.id.slogan);

        logo = findViewById(R.id.logo);
        jobs = findViewById(R.id.jobs);
        customers = findViewById(R.id.custormers);

        nxtPage = findViewById(R.id.nxtPage);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        slogan.setAnimation(from_left);
        sloganimg.setAnimation(from_left);
        logo.setAnimation(from_top);
        jobs.setAnimation(from_left);
        customers.setAnimation(from_left);
        nxtPage.setAnimation(from_bottom);
        figthing.setAnimation(from_right);
    }

    public void onCLicked(){
        nxtPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeGuestActivity.this, GuestMainPageActivity.class));
            }
        });
    }
}