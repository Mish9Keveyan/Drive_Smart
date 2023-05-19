package com.example.learntodrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class BookActivity extends AppCompatActivity {

    Button buttonSigns;
    Button buttonTrafficLaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ImageView back = findViewById(R.id.imageRule1);
        back.setOnClickListener(view -> finish());

        buttonSigns = findViewById(R.id.buttonSigns);
        buttonTrafficLaw = findViewById(R.id.buttonTrafficLaw);

        buttonSigns.setOnClickListener(view -> openBook(0));
        buttonTrafficLaw.setOnClickListener(view -> openBook(1));
    }

    private void openBook(int position) {
        Intent intent = new Intent(BookActivity.this, Books.class);
        intent.putExtra("key_position", position);
        startActivity(intent);
    }
}
