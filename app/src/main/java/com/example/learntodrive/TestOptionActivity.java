package com.example.learntodrive;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.learntodrive.Signs.TrafficSignsActivity;

public class TestOptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_option);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        CardView cvTrafficSigns = findViewById(R.id.cvTrafficSigns);
        CardView cvCrossRoads = findViewById(R.id.cvCrossroads);

        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cvTrafficSigns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestOptionActivity.this , TrafficSignsActivity.class));
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
