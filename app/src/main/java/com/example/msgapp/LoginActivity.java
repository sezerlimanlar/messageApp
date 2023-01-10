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

public class LoginActivity extends AppCompatActivity {
    Button signup, login;
    EditText email, password;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup = (Button) findViewById(R.id.btn_log_signup);
        login = (Button) findViewById(R.id.btn_log_login);
        email = (EditText) findViewById(R.id.et_log_email);
        password = (EditText) findViewById(R.id.et_log_password);

        firebaseAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logClick();
            }
        });
    }

    public void logClick() {
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        if(userEmail.isEmpty()) {
            Toast.makeText(this,"Email bilgisi boş olamaz",Toast.LENGTH_SHORT).show();
        }
        if(userPassword.isEmpty() || userPassword.length()<6) {
            Toast.makeText(this, "Şifre eksik veya 6 karakterden az", Toast.LENGTH_SHORT).show();
        }
        firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Giriş Başarılı Yönlendiriliyorsunuz", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Giriş başarısız", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public void sigClick(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }
}
