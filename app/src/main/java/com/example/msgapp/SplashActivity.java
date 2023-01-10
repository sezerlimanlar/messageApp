package com.example.msgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Thread sleep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        firebaseAuth = FirebaseAuth.getInstance();
        splashTreah();

        if(firebaseAuth.getCurrentUser() != null){
            Toast.makeText(this,"Zaten giriş yapmıştınız yönlendiriliyorsunuz.", Toast.LENGTH_SHORT).show();
            sleep.start();
        }

    }

    public void splashloginClick(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void splashsignupClick(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
    public void splashTreah(){
    sleep = new Thread(){
        @Override
        public void run() {
            try {
                sleep(2000);
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    }
}