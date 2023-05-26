package com.example.learntodrive;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Trophies extends AppCompatActivity {
    View v11,v12,v13,v14,v21,v22,v23,v24,v31,v32,v33,v34,v41,v42,v43,v44;
    TextView TV1,TV2,TV3,TV4;
    ImageView TrafficSigns,Balance,FirstHelp,Crossroads,a1;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophies);
        findViewById(R.id.imageViewQuizOption).setOnClickListener(view -> finish());
        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        v11 = findViewById(R.id.v11);v12 = findViewById(R.id.v12);v13 = findViewById(R.id.v13);v14 = findViewById(R.id.v14);
        v21 = findViewById(R.id.v21);v22 = findViewById(R.id.v22);v23 = findViewById(R.id.v23);v24 = findViewById(R.id.v24);
        v31 = findViewById(R.id.v31);v32 = findViewById(R.id.v32);v33 = findViewById(R.id.v33);v34 = findViewById(R.id.v34);
        v41 = findViewById(R.id.v41);v42 = findViewById(R.id.v42);v43 = findViewById(R.id.v43);v44 = findViewById(R.id.v44);
        TV1 = findViewById(R.id.TV1);TV2 = findViewById(R.id.TV2);TV3 = findViewById(R.id.TV3);TV4 = findViewById(R.id.TV4);
        TrafficSigns = findViewById(R.id.imageView10);
        Crossroads = findViewById(R.id.imageView11);
        FirstHelp = findViewById(R.id.imageView12);
        Balance = findViewById(R.id.imageView13);
        a1 = findViewById(R.id.korona1);
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        CardView cvTrafficSigns = findViewById(R.id.cvTrafficSigns);
        CardView cvCrossroads = findViewById(R.id.cvCrossroads);
        CardView cvFirstHelp = findViewById(R.id.cvFirst_help);
        CardView cvBalance = findViewById(R.id.cvLaw);
        TextView textView1 = findViewById(R.id.textView3);
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
        cvTrafficSigns.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view){
                    if (level >= 5){
                        Toast.makeText(Trophies.this, "Поздравляю вы прошли тест Дорожние знаки", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Trophies.this, "Пройдите тесты, чтобы получить трофеи", Toast.LENGTH_SHORT).show();
                    }
            }
            
        });
        cvCrossroads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Trophies.this, "Пройдите тесты, чтобы получить трофеи", Toast.LENGTH_SHORT).show();
            }
        });
        cvFirstHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Trophies.this, "Пройдите тесты, чтобы получить трофеи", Toast.LENGTH_SHORT).show();
            }
        });
        cvBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Trophies.this, "Пройдите тесты, чтобы получить трофеи", Toast.LENGTH_SHORT).show();
            }
        });

        if (level >= 2) {
            v11.setBackgroundResource(R.color.bg_color);
            TV1.setTextColor(getResources().getColor(R.color.bg_color));
            TV1.setText("25%");
        }
        if (level >= 3) {
            v12.setBackgroundResource(R.color.bg_color);
            TV1.setTextColor(getResources().getColor(R.color.bg_color));
            TV1.setText("50%");
        }
        if (level >= 4) {
            v13.setBackgroundResource(R.color.bg_color);
            TV1.setTextColor(getResources().getColor(R.color.bg_color));
            TV1.setText("75%");
        }
        if (level >= 5) {
            v11.setBackgroundResource(R.color.white);
            v12.setBackgroundResource(R.color.white);
            v13.setBackgroundResource(R.color.white);
            v14.setBackgroundResource(R.color.white);
            TV1.setText("100%");
            TV1.setTextColor(getResources().getColor(R.color.white));
            textView1.setTextColor(getResources().getColor(R.color.white));
            cvTrafficSigns.setBackgroundResource(R.color.Gold);
            Picasso.get()
                    .load("https://firebasestorage.googleapis.com/v0/b/drive-smart-b1101.appspot.com/o/a.png?alt=media&token=0f2496fb-d2ef-433e-a3de-f79d7c653e6c")
                    .into(a1);
        }

    }
}