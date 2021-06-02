package com.example.hrapp.authenfication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hrapp.R;
import com.example.hrapp.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin, btnRegister;
    TextInputEditText name, email, password;
    FirebaseAuth fAuth;
    User user;
    String emailformat;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViews();
    }

    public void initViews(){
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        fAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegister){
            String uname = name.getText().toString();
            String uemail = email.getText().toString();
            String upassword = password.getText().toString();
            if (uname.isEmpty()){
                name.setError("Full name is requied");
                return;
            }
            if (uemail.isEmpty()){
                email.setError("Email is requied");
                return;
            }
            if (upassword.isEmpty()){
                password.setError("Password is requied");
                return;
            }

            fAuth.createUserWithEmailAndPassword(uemail, upassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
//                        Log.i("gogpo", "123 " + uemail + upassword);
                    user = new User(uname, uemail, upassword, "0", "1", "2", "3", "4", "5", "6");
                    emailformat = user.getEmail().replace(".", "-");
                    myRef.child("users").child(emailformat).setValue(user);
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);
                    Toast.makeText(Registration.this, "Tirkeldiniz", Toast.LENGTH_SHORT).show();
//                        finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Registration.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if(v.getId() == R.id.btnLogin){
            Intent in = new Intent(Registration.this, Login.class);
            startActivity(in);
        }
    }
}