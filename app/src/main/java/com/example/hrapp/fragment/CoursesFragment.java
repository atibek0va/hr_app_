package com.example.hrapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hrapp.R;
import com.example.hrapp.activities.AllCoursesActivity;
import com.example.hrapp.activities.Doctors;

public class CoursesFragment extends Fragment {
    View view;
    Button allCourses, financist, manager, account, hr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_courses, container, false);
        allCourses = view.findViewById(R.id.allCourses);
        financist = view.findViewById(R.id.forFinance);
        manager = view.findViewById(R.id.forManager);
        account = view.findViewById(R.id.forAccount);
        hr = view.findViewById(R.id.forHR);

        allCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllCoursesActivity.class));
            }
        });
        financist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllCoursesActivity.class));
            }
        });
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllCoursesActivity.class));
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllCoursesActivity.class));
            }
        });
        hr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AllCoursesActivity.class));
            }
        });

        return view;
    }
}