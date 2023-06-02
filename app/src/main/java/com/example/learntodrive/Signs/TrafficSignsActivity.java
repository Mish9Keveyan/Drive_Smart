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
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.learntodrive.Questions;
import com.example.learntodrive.R;
import com.example.learntodrive.TestOptionActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class TrafficSignsActivity extends AppCompatActivity {
    private Timer timer;
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
        CardView cvLevel4 = findViewById(R.id.cvLevel4);
        TextView cv1 = findViewById(R.id.newDrive);
        TextView cv2 = findViewById(R.id.smartDrive);
        TextView cv3 = findViewById(R.id.truckDrive);
        TextView cv4 = findViewById(R.id.drivingInstructor);
        ImageView lockLevel1 = findViewById(R.id.lockLevel1);
        ImageView lockLevel2 = findViewById(R.id.lockLevel2);
        ImageView lockLevel3 = findViewById(R.id.lockLevel3);
        ImageView lockLevel4 = findViewById(R.id.lockLevel4);
        ConstraintLayout constraintLayout1 = findViewById(R.id.ConstraintLayout1);
        ConstraintLayout constraintLayout2 = findViewById(R.id.ConstraintLayout2);
        ConstraintLayout constraintLayout3 = findViewById(R.id.ConstraintLayout3);
        ConstraintLayout constraintLayout4 = findViewById(R.id.ConstraintLayout4);

        ImageView One = findViewById(R.id.imageView11);
        ImageView Two = findViewById(R.id.imageView12);
        ImageView Three = findViewById(R.id.imageView13);
        ImageView Four = findViewById(R.id.imageView14);

        constraintLayout1.setBackgroundColor(Color.WHITE);
        cv1.setTextColor(Color.BLACK);
        lockLevel1.setVisibility(View.GONE);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference One1 = database.getReference("Levels/One");
        DatabaseReference Two2 = database.getReference("Levels/Two");
        DatabaseReference Three3 = database.getReference("Levels/Three");
        DatabaseReference Four4 = database.getReference("Levels/Four");

        One1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(One);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        Two2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(Two);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        Three3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(Three);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        Four4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(Four);
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

        cvLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(TrafficSignsActivity.this, FirstLevelActivity.class));
                    finish();
            }
        });
        //Levels logic start
        if (level >= 2) {
            constraintLayout2.setBackgroundColor(Color.WHITE);
            cv2.setTextColor(Color.BLACK);
            lockLevel2.setVisibility(View.GONE);
        }
        if (level >= 3) {
            constraintLayout3.setBackgroundColor(Color.WHITE);
            cv3.setTextColor(Color.BLACK);
            lockLevel3.setVisibility(View.GONE);
        }
        if (level >= 4) {
            constraintLayout4.setBackgroundColor(Color.WHITE);
            cv4.setTextColor(Color.BLACK);
            lockLevel4.setVisibility(View.GONE);
        }
        cvLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (level >= 2) {
                    startActivity(new Intent(TrafficSignsActivity.this, SecondLevelActivity.class));
                    finish();
                } else {
                    Toast.makeText(TrafficSignsActivity.this, "Пока недоступно", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cvLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (level >= 3) {
                    startActivity(new Intent(TrafficSignsActivity.this, ThirdLevelActivity.class));
                    finish();
                } else {
                    Toast.makeText(TrafficSignsActivity.this, "Пока недоступно", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cvLevel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (level >= 4) {
                    startActivity(new Intent(TrafficSignsActivity.this, FourthLevelActivity.class));
                    finish();
                } else {
                    Toast.makeText(TrafficSignsActivity.this, "Пока недоступно", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Levels logic end
    }
}
