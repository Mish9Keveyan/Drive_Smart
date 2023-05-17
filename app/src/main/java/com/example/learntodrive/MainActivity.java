package com.example.learntodrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Context context;


    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cvStartTest = findViewById(R.id.cvStartTest);
        CardView cvLogout = findViewById(R.id.cvLogout);
        CardView cvTrophy = findViewById(R.id.cvLogo);
        CardView cvBook = findViewById(R.id.cvBook);
        CardView cvRules = findViewById(R.id.cvRules);
        ImageView imageView = findViewById(R.id.account_icon);
        mAuth = FirebaseAuth.getInstance();

        cvStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isConnected()) {
                    startActivity(new Intent(MainActivity.this, TestOptionActivity.class));
                }else {
                    startActivity(new Intent(MainActivity.this, NoInternet.class));
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isConnected()) {
                    if (mAuth.getCurrentUser() == null) {
                        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                    } else {
                        startActivity(new Intent(MainActivity.this, AccountActivity.class));
                    }
                }else {
                    startActivity(new Intent(MainActivity.this, NoInternet.class));
                }
            }
        });
        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAuth.getCurrentUser() != null) {
                    Toast.makeText(MainActivity.this, "Вы успешно вышли из аккаунта", Toast.LENGTH_LONG).show();
                }
                FirebaseAuth.getInstance().signOut();
            }
        });
        cvTrophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isConnected()) {
                    if (mAuth.getCurrentUser() == null) {
                        startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                    } else {
                        startActivity(new Intent(MainActivity.this, Trophies.class));
                    }
                } else {
                    startActivity(new Intent(MainActivity.this, NoInternet.class));
                }
            }
        });
        cvBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,BookActivity.class));
            }
        });
        cvRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RulesActivity.class));
            }
        });

    }
}
