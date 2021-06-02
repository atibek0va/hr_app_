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
import com.example.hrapp.adapter.CoursesAdapter;
import com.example.hrapp.adapter.DoctorAdapter;
import com.example.hrapp.fragment.PsychFragment;
import com.example.hrapp.model.Course;
import com.example.hrapp.model.Doctor;

import java.util.ArrayList;

public class AllCoursesActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    ImageView btnBack;
    RecyclerView recyclerView;
    CoursesAdapter coursesAdapter;
    ArrayList<Course> courseList;
    private RecyclerView.LayoutManager linearLayoutManager;

    Animation from_bottom,from_top,  from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_courses);
        initViews();
        getCourse();
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
        courseList = new ArrayList<>();
        coursesAdapter = new CoursesAdapter(this, courseList);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(coursesAdapter);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }
    public void setAnimation(){
        toolbar.setAnimation(from_left);
        recyclerView.setAnimation(from_right);
    }

    public void getCourse(){
        courseList.add(new Course(R.drawable.courses,"Human Resource Management: HR for People Managers\n", "University of Minnesota"));
        courseList.add(new Course(R.drawable.course2,"Human Resource Analytics: HR for People Managers\n", "University of California, Irvine"));
        courseList.add(new Course(R.drawable.course3,"Accounting Data Analytics", "University of Illinois at Urbana-Champaign"));
        courseList.add(new Course(R.drawable.course4,"Positive Psychiatry and Mental", "The University of Sydney"));
        courseList.add(new Course(R.drawable.course5,"Project Management Principles and Practices", "University of California, Irvine"));
        coursesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back){
            startActivity(new Intent(AllCoursesActivity.this, MainPageActivity.class));
        }
    }
}