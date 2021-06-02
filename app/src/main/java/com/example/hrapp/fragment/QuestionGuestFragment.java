package com.example.hrapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hrapp.R;
import com.example.hrapp.activities.NewQuestionActivity;
import com.example.hrapp.adapter.QuestionAdapter;
import com.example.hrapp.model.Question;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuestionGuestFragment extends Fragment {
    FloatingActionButton fab;

    View view;
    RecyclerView recyclerView;
    ArrayList<Question> questionList;
    QuestionAdapter questionAdapter;
    DatabaseReference myRef;
    FirebaseDatabase database;
    String userCurrentEmail;
    FirebaseAuth auth;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_question_guest, container, false);

        fab = view.findViewById(R.id.floatbtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NewQuestionActivity.class));
            }
        });

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        auth = FirebaseAuth.getInstance();

        recyclerView = view.findViewById(R.id.recycleQuestions);
        questionList = new ArrayList<>();
        questionAdapter = new QuestionAdapter(getContext(), questionList);

//        questionList.add(new Question("What type of education qualification is needed for getting good job in company", "Asked May 1 ,2021"));
//        questionList.add(new Question("What type of education qualification is needed for getting good job in company", "Asked May 1 ,2021"));
//        questionList.add(new Question("What type of education qualification is needed for getting good job in company", "Asked May 1 ,2021"));
//        questionList.add(new Question("What type of education qualification is needed for getting good job in company", "Asked May 1 ,2021"));
//        questionList.add(new Question("What type of education qualification is needed for getting good job in company", "Asked May 1 ,2021"));
//        questionList.add(new Question("What type of education qualification is needed for getting good job in company", "Asked May 1 ,2021"));
        myRef.child("questions").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot questions: snapshot.getChildren()) {
                        Question question = questions.getValue(Question.class);
                        questionList.add(question);
                    }
                    questionAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        linearLayoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(questionAdapter);

//        recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), JobDescriptionActivity.class));
//            }
//        });

        return view;
    }
}