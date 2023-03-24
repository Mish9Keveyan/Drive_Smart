package com.example.learntodrive.Signs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.learntodrive.R;

public class TrafficSignsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_signs);

        CardView cvLevel1 = findViewById(R.id.cvLevel1);
        CardView cvLevel2 = findViewById(R.id.cvLevel2);

        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cvLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrafficSignsActivity.this, FirstLevelActivity.class));
            }
        });
        cvLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrafficSignsActivity.this,SecondLevelActivity.class));
            }
        });

    }
}
