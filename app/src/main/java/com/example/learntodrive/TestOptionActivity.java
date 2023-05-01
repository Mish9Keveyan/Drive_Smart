package com.example.learntodrive;


import static java.lang.Thread.sleep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
    ProgressBar progressBar2;

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
        progressBar2 = findViewById(R.id.progressBar2);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference Image1 = database.getReference("Traffic Signs");
        DatabaseReference Image2 = database.getReference("Crossroads");
        DatabaseReference Image3 = database.getReference("FirstHelp");
        DatabaseReference Image4 = database.getReference("Balance");

        Image1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (progressBar2 != null){

                    progressBar2.setVisibility(View.GONE);
                    String value = snapshot.getValue(String.class);
                    Picasso.get().load(value).into(TrafficSigns);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Image2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (progressBar2 != null){
                    progressBar2.setVisibility(View.GONE);
                }
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(Crossroads);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Image3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (progressBar2 != null){
                    progressBar2.setVisibility(View.GONE);
                }
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(FirstHelp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Image4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (progressBar2 != null){
                    progressBar2.setVisibility(View.GONE);
                }
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
                Toast.makeText(TestOptionActivity.this, "Пока недоступно", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
