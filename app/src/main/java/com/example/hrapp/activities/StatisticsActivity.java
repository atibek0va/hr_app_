package com.example.hrapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hrapp.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    ImageView btnExit, profile_img;
    TextView monthly;
    LinearLayout statisticLayout;

    Animation from_bottom, from_top, from_right, from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
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
        btnExit = findViewById(R.id.btnExit);
        profile_img = findViewById(R.id.profile_img);

        monthly = findViewById(R.id.monthly);

        statisticLayout = findViewById(R.id.statisticLayout);

        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> moods = new ArrayList<>();

        moods.add(new BarEntry(4, 507));
        moods.add(new BarEntry(4, 100));
        moods.add(new BarEntry(4, 300));
        moods.add(new BarEntry(4, 30));

        BarDataSet barDataSet = new BarDataSet(moods, "Moods");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar chart example");
        barChart.animateY(2000);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
    }

    public void setAnimation(){
        profile_img.setAnimation(from_bottom);
        statisticLayout.setAnimation(from_bottom);
        monthly.setAnimation(from_right);
        btnExit.setAnimation(from_bottom);
    }

    public void onClicked(){
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StatisticsActivity.this, ProfileActivity.class));
            }
        });
    }
}