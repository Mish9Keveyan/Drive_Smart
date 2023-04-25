package com.example.learntodrive.Signs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.learntodrive.Questions;
import com.example.learntodrive.R;

public class TrafficSignsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_signs);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        CardView cvLevel1 = findViewById(R.id.cvLevel1);
        CardView cvLevel2 = findViewById(R.id.cvLevel2);
        CardView cvLevel3 = findViewById(R.id.cvLevel3);
        TextView cv1 = findViewById(R.id.newDrive);
        TextView cv2 = findViewById(R.id.smartDrive);
        TextView cv3 = findViewById(R.id.truckDrive);
        ImageView lockLevel1 = findViewById(R.id.lockLevel1);
        ImageView lockLevel2 = findViewById(R.id.lockLevel2);
        ImageView lockLevel3 = findViewById(R.id.lockLevel3);
        ConstraintLayout constraintLayout1 = findViewById(R.id.ConstraintLayout1);
        ConstraintLayout constraintLayout2 = findViewById(R.id.ConstraintLayout2);

        constraintLayout1.setBackgroundColor(Color.WHITE);
        cv1.setTextColor(Color.BLACK);
        lockLevel1.setVisibility(View.GONE);

        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cvLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (level >= 1) {
                    startActivity(new Intent(TrafficSignsActivity.this, FirstLevelActivity.class));
                } else {
                    Toast.makeText(TrafficSignsActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (level >= 2) {
            constraintLayout2.setBackgroundColor(Color.WHITE);
            cv2.setTextColor(Color.BLACK);
            lockLevel2.setVisibility(View.GONE);
        }
        cvLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (level >= 2) {
                    startActivity(new Intent(TrafficSignsActivity.this, SecondLevelActivity.class));
                } else {
                    Toast.makeText(TrafficSignsActivity.this, "Пока недоступно", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cvLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TrafficSignsActivity.this, "Пока недоступно", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
