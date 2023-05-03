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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);

        TextView tvUsername = findViewById(R.id.tvUsernameHome);
        CardView cvStartTest = findViewById(R.id.cvStartTest);
        CardView cvLogout = findViewById(R.id.cvLogout);
        ImageView imageView = findViewById(R.id.account_icon);
        ImageView Logout = findViewById(R.id.imageLogout);
        ImageView StartTest = findViewById(R.id.imageTest);
        mAuth = FirebaseAuth.getInstance();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Image1 = database.getReference("mainActivity/Logout");
        DatabaseReference Image2 = database.getReference("mainActivity/StartTest");

        Image1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (progressBar != null){
                    progressBar.setVisibility(View.GONE);
                    String value = snapshot.getValue(String.class);
                    Picasso.get().load(value).into(Logout);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Image2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                    String value = snapshot.getValue(String.class);
                    Picasso.get().load(value).into(StartTest);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        cvStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isConnected()) {
                    startActivity(new Intent(MainActivity.this, TestOptionActivity.class));
                }else {
                    startActivity(new Intent(MainActivity.this, Activity_splash_screen.class));
                }
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
