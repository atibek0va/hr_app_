package com.example.hrapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hrapp.R;
import com.example.hrapp.adapter.JobAdapter;
import com.example.hrapp.adapter.RespondAdapter;
import com.example.hrapp.model.Doctor;
import com.example.hrapp.model.Respond;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class RespondsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Respond> respondList;
    RespondAdapter respondAdapter;
    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responds);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();


        recyclerView = findViewById(R.id.recycleResponds);
//        respondList = new ArrayList<>();
        respondList = new ArrayList<>();
        respondAdapter = new RespondAdapter(this, respondList);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

//        respondList.add(new Respond("Work experience: 6 years", "+7 708 419 54 22"));
//        respondAdapter.notifyDataSetChanged();
        myRef.child("responds").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot responds: snapshot.getChildren()) {
                        Respond respond = responds.getValue(Respond.class);
                        respondList.add(respond);
                    }
                    respondAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recyclerView.setAdapter(respondAdapter);
    }
}