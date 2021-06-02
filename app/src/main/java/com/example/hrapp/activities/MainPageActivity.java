package com.example.hrapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.hrapp.R;
import com.example.hrapp.fragment.CoursesFragment;
import com.example.hrapp.fragment.FinanceFragment;
import com.example.hrapp.fragment.HomeFragment;
import com.example.hrapp.fragment.PsychFragment;
import com.example.hrapp.fragment.QuestionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainPageActivity extends AppCompatActivity {

    Toolbar toolbar;

    ImageView notifications;
    CircleImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        initViews();
        onClicked();
    }

    public void initViews(){
        toolbar = findViewById(R.id.main_tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        notifications = findViewById(R.id.notification);
        profile = findViewById(R.id.profile);

        BottomNavigationView btnNav = findViewById(R.id.bottom_nav);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, new HomeFragment()).commit();
    }

    public void onClicked(){

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPageActivity.this, MessageActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPageActivity.this, ProfileActivity.class));
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.course:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.finance:
                    selectedFragment = new FinanceFragment();
                    break;
                case R.id.med:
                    selectedFragment = new CoursesFragment();
                    break;
                case R.id.psych:
                    selectedFragment = new PsychFragment();
                    break;
                case R.id.faq:
                    selectedFragment = new QuestionFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_layout,
                            selectedFragment).commit();
            return true;
        }
    };

}