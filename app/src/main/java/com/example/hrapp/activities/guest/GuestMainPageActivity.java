package com.example.hrapp.activities.guest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.hrapp.R;
import com.example.hrapp.fragment.ContactsFragment;
import com.example.hrapp.fragment.FinanceFragment;
import com.example.hrapp.fragment.GuestQuestionFragment;
import com.example.hrapp.fragment.HomeFragment;
import com.example.hrapp.fragment.JobsFragment;
import com.example.hrapp.fragment.PsychFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GuestMainPageActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_main_page);
        initViews();
    }

    public void initViews(){
        toolbar = findViewById(R.id.main_guest_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView btnNav = findViewById(R.id.bottom_nav);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_guest, new JobsFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.jobs:
                    selectedFragment = new JobsFragment();
                    break;
                case R.id.contacts:
                    selectedFragment = new ContactsFragment();
                    break;
                case R.id.question:
                    selectedFragment = new GuestQuestionFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_guest,
                            selectedFragment).commit();
            return true;
        }
    };

}