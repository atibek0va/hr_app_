package com.example.hrapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hrapp.activities.Doctors;
import com.example.hrapp.R;

public class PsychFragment extends Fragment {

    View view;
    LinearLayout person, family, socail, education;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_psych, container, false);

        person = view.findViewById(R.id.person);
        family = view.findViewById(R.id.family);
        socail = view.findViewById(R.id.social);
        education = view.findViewById(R.id.education);

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Doctors.class));
            }
        });
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Doctors.class));
            }
        });
        socail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Doctors.class));
            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Doctors.class));
            }
        });

        return view;

    }
}