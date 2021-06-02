package com.example.hrapp.activities.financesupport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hrapp.R;
import com.example.hrapp.fragment.FinanceFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LaptopActivity extends AppCompatActivity {

    TextView abthealthcare;
    Toolbar toolbar;
    ImageView btnBack;
    DatabaseReference myRef;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);
        initViews();
        onClicked();
    }
     public void initViews(){
        toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);

        abthealthcare = findViewById(R.id.abthealthcare);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.child("finance supports").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot support: snapshot.getChildren()) {
//                        String aboutHealthcare = support.child("healthcare").getValue().toString();
//                        abtHealth.setText(aboutHealthcare);
                        String data = snapshot.child("healthcare").getValue(String.class);
                        abthealthcare.setText(data);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnBack = findViewById(R.id.back);
    }
    public void onClicked(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LaptopActivity.this, FinanceFragment.class));
            }
        });
    }
}