package com.example.learntodrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
public class Activity_splash_screen extends AppCompatActivity {
    Context context;
    TextView textView;
    private View mainView;
    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
    private ImageView appLogo;
    private ImageView noInet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        appLogo = findViewById(R.id.appLogo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.first_animation);
        appLogo.setAnimation(animation);
        mainView = findViewById(R.id.mainView);
        noInet = findViewById(R.id.NoInternet);
        textView = findViewById(R.id.textView7);
        if (!isConnected()){
            ImageView appLogo1 = appLogo;
            appLogo1.setVisibility(View.GONE);
            mainView.setBackgroundColor(Color.WHITE);
            noInet.setVisibility(View.VISIBLE);
        }else {
            textView.setVisibility(View.GONE);
            noInet.setVisibility(View.GONE);
            new Thread(){
                public void run(){
                    try {
                        sleep(2000);
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }.start();
        }
    }
}

