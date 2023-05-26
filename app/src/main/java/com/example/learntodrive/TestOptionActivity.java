package com.example.learntodrive;


import static java.lang.Thread.sleep;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.learntodrive.CrossRoads.CrossRoadsActivity;
import com.example.learntodrive.Signs.TrafficSignsActivity;
import com.google.api.Http;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestOptionActivity extends AppCompatActivity {
    ImageView TrafficSigns;
    ImageView Crossroads;
    ImageView FirstHelp;
    ImageView Balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_option);

        CardView cvTrafficSigns = findViewById(R.id.cvTrafficSigns);
        CardView cvCrossRoads = findViewById(R.id.cvCrossroads);
        CardView cvFirstHelp = findViewById(R.id.cvFirst_help);
        CardView cvLaw = findViewById(R.id.cvLaw);
        TrafficSigns = findViewById(R.id.imageView10);
        Crossroads = findViewById(R.id.imageView11);
        FirstHelp = findViewById(R.id.imageView12);
        Balance = findViewById(R.id.imageView13);
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        Handler handler = new Handler();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Traffic_Signs68 = database.getReference("Traffic Signs");
        DatabaseReference Crossroads69 = database.getReference("Crossroads");
        DatabaseReference FirstHelp70 = database.getReference("FirstHelp");
        DatabaseReference Balance71 = database.getReference("Balance");

        Traffic_Signs68.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                    String value = snapshot.getValue(String.class);
                    Picasso.get().load(value).into(TrafficSigns);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Crossroads69.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(Crossroads);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirstHelp70.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(FirstHelp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Balance71.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(Balance);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestOptionActivity.this,MainActivity.class));
                finish();
            }
        });
        cvTrafficSigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestOptionActivity.this, TrafficSignsActivity.class));
            }
        });
        cvCrossRoads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestOptionActivity.this, CrossRoadsActivity.class));}
        });
    }
}
