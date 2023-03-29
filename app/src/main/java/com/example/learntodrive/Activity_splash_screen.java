package com.example.learntodrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class Activity_splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Activity_splash_screen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },1000);
        }
    }
}
