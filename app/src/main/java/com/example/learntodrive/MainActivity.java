package com.example.learntodrive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tvUsername = findViewById(R.id.tvUsernameHome);
        CardView cvStartTest = findViewById(R.id.cvStartTest);
        CardView cvLogout = findViewById(R.id.cvLogout);
        ImageView imageView = findViewById(R.id.account_icon);
        mAuth = FirebaseAuth.getInstance();

        cvStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TestOptionActivity.class));
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAuth.getCurrentUser() == null) {
                    startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                }else {
                    startActivity(new Intent(MainActivity.this, AccountActivity.class));
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

    }
}
