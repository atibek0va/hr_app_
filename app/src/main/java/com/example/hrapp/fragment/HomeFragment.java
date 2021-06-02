package com.example.hrapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hrapp.R;
import com.example.hrapp.model.Employee;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    View view;
    Button positive, ortasha, superMood, jaman, depression, stress;
    TextView userName, sucVoted;

    FirebaseAuth auth;
    DatabaseReference databaseReference;
    String userCurrent;
    Employee userm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home, container, false);

        positive = view.findViewById(R.id.positive);
        ortasha = view.findViewById(R.id.ortasha);
        superMood = view.findViewById(R.id.superMood);
        jaman = view.findViewById(R.id.jaman);
        depression = view.findViewById(R.id.depression);
        stress = view.findViewById(R.id.stress);

        userName = view.findViewById(R.id.userName);
        sucVoted = view.findViewById(R.id.sucVoted);

        positive.getBackground().setAlpha(64);
        ortasha.getBackground().setAlpha(64);
        superMood.getBackground().setAlpha(64);
        jaman.getBackground().setAlpha(64);
        depression.getBackground().setAlpha(64);
        stress.getBackground().setAlpha(64);

        positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upositive = positive.getText().toString();
                databaseReference.child("users").child(userCurrent).child("moods").child("positive").setValue(upositive);

                ortasha.setClickable(false);
                superMood.setClickable(false);
                jaman.setClickable(false);
                depression.setClickable(false);
                stress.setClickable(false);

                ortasha.getBackground().setAlpha(25);
                superMood.getBackground().setAlpha(25);
                jaman.getBackground().setAlpha(25);
                depression.getBackground().setAlpha(25);
                stress.getBackground().setAlpha(25);

                sucVoted.setVisibility(View.VISIBLE);
            }
        });
        ortasha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uortasha = ortasha.getText().toString();
                databaseReference.child("users").child(userCurrent).child("moods").child("ortasha").setValue(uortasha);

                positive.setClickable(false);
                superMood.setClickable(false);
                jaman.setClickable(false);
                depression.setClickable(false);
                stress.setClickable(false);

                positive.getBackground().setAlpha(25);
                superMood.getBackground().setAlpha(25);
                jaman.getBackground().setAlpha(25);
                depression.getBackground().setAlpha(25);
                stress.getBackground().setAlpha(25);

                sucVoted.setVisibility(View.VISIBLE);
            }
        });
        superMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuper = superMood.getText().toString();
                databaseReference.child("users").child(userCurrent).child("moods").child("super").setValue(usuper);
                ortasha.setClickable(false);
                positive.setClickable(false);
                jaman.setClickable(false);
                depression.setClickable(false);
                stress.setClickable(false);

                ortasha.getBackground().setAlpha(25);
                positive.getBackground().setAlpha(25);
                jaman.getBackground().setAlpha(25);
                depression.getBackground().setAlpha(25);
                stress.getBackground().setAlpha(25);

                sucVoted.setVisibility(View.VISIBLE);
            }
        });
        jaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ujaman = jaman.getText().toString();
                databaseReference.child("users").child(userCurrent).child("moods").child("jaman").setValue(ujaman);
                ortasha.setClickable(false);
                superMood.setClickable(false);
                positive.setClickable(false);
                depression.setClickable(false);
                stress.setClickable(false);

                ortasha.getBackground().setAlpha(25);
                superMood.getBackground().setAlpha(25);
                positive.getBackground().setAlpha(25);
                depression.getBackground().setAlpha(25);
                stress.getBackground().setAlpha(25);

                sucVoted.setVisibility(View.VISIBLE);
            }
        });
        depression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String udepress = depression.getText().toString();
                databaseReference.child("users").child(userCurrent).child("moods").child("depression").setValue(udepress);
                ortasha.setClickable(false);
                superMood.setClickable(false);
                jaman.setClickable(false);
                positive.setClickable(false);
                stress.setClickable(false);

                ortasha.getBackground().setAlpha(25);
                superMood.getBackground().setAlpha(25);
                jaman.getBackground().setAlpha(25);
                positive.getBackground().setAlpha(25);
                stress.getBackground().setAlpha(25);

                sucVoted.setVisibility(View.VISIBLE);
            }
        });
        stress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ustress = stress.getText().toString();
                databaseReference.child("users").child(userCurrent).child("moods").child("stress").setValue(ustress);
                ortasha.setClickable(false);
                superMood.setClickable(false);
                jaman.setClickable(false);
                depression.setClickable(false);
                positive.setClickable(false);

                ortasha.getBackground().setAlpha(25);
                superMood.getBackground().setAlpha(25);
                jaman.getBackground().setAlpha(25);
                depression.getBackground().setAlpha(25);
                positive.getBackground().setAlpha(25);

                sucVoted.setVisibility(View.VISIBLE);
            }
        });

        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        user_info();

        return view;
    }

    public void user_info(){
        userCurrent = auth.getCurrentUser().getEmail().replace(".", "-");
        Log.i("currentUser", userCurrent);

        getInfo(userCurrent);
    }

    private void getInfo(String userCurrent) {
        databaseReference.child("users").child(userCurrent).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userm = snapshot.getValue(Employee.class);
                userName.setText(userm.getEmployeeName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}