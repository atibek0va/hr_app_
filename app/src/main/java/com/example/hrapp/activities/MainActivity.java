package com.example.hrapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.hrapp.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout person, family, socail, education;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        onClick();
    }

    public void initViews(){
        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);

        person = findViewById(R.id.person);
        family = findViewById(R.id.family);
        socail = findViewById(R.id.social);
        education = findViewById(R.id.education);
    }

    public void onClick(){
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Doctors.class));
            }
        });
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Doctors.class));
            }
        });
        socail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Doctors.class));
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Doctors.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}