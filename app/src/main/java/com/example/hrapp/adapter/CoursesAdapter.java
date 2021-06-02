package com.example.hrapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hrapp.R;
import com.example.hrapp.activities.BronActivity;
import com.example.hrapp.model.Course;
import com.example.hrapp.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.MyTViewHolder>{
    private Context context;
    private List<Course> courseList;

    public CoursesAdapter(List<Course> courseList) {
    }

    public class MyTViewHolder extends RecyclerView.ViewHolder{
        public ImageView coursePhoto;
        public TextView courseName, courseUniver;

        public MyTViewHolder(View view){
            super(view);
            coursePhoto = view.findViewById(R.id.coursePhoto);
            courseName = view.findViewById(R.id.courseName);
            courseUniver = view.findViewById(R.id.courseUniver);
        }
    }
    public CoursesAdapter(Context context, ArrayList<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public MyTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_courses, parent, false);

        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTViewHolder holder, int position) {
        Course item = courseList.get(position);

        holder.coursePhoto.setImageResource(item.getCoursePhoto());
        holder.courseName.setText(item.getCourseName());
        holder.courseUniver.setText(item.getCourseUniver());


    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }
}
