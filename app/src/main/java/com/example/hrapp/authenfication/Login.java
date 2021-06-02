package com.example.hrapp.authenfication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hrapp.activities.MainPageActivity;
import com.example.hrapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin;
    TextInputEditText email, password;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    public void initViews(){
        firebaseAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.textEmail);
        password = findViewById(R.id.textPassword);

        email.getBackground().setAlpha(64);
        password.getBackground().setAlpha(64);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin){
            String uemail = email.getText().toString();
            String upassword = password.getText().toString();

            if (uemail.isEmpty()){
                email.setError("Write your email");
                return;
            }
            if (upassword.isEmpty()){
                password.setError("Write your password");
                return;
            }

            firebaseAuth.signInWithEmailAndPassword(uemail, upassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    startActivity(new Intent(getApplicationContext(), MainPageActivity.class));
                    Toast.makeText(Login.this, "Welcome!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    //    @Override
//    protected void onStart() {
//        super.onStart();
//        if(FirebaseAuth.getInstance().getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            finish();
//        }
//    }
}