package com.example.msgapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    Button signup, login;
    EditText email, password;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signup = (Button) findViewById(R.id.btn_sig_signup);
        login = (Button) findViewById(R.id.btn_sig_login);

        email = (EditText) findViewById(R.id.et_sig_email);
        password = (EditText) findViewById(R.id.et_sig_password);

        firebaseAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupClick();
            }
        });

    }
    public void signupClick() {
    String userEmail = email.getText().toString();
    String userPassword = password.getText().toString();
    if(userEmail.isEmpty()) {
        Toast.makeText(this,"Email bilgisi boş olamaz.", Toast.LENGTH_SHORT).show();
    }
        if(userPassword.isEmpty() || userPassword.length()<6) {
            Toast.makeText(this,"Şifre eksik veya 6 karakterden az", Toast.LENGTH_SHORT).show();
        }
        firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"KAYIT BAŞARILI", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }else{
                    Toast.makeText(RegisterActivity.this,"KAYIT BAŞARISIZ",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void logClick(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}