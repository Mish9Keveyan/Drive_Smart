package com.example.learntodrive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

public class Books extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);
        pdfView = findViewById(R.id.pdfView);
        ImageView back= findViewById(R.id.imageRule1);

        back.setOnClickListener(view -> finish());

        int test_position = getIntent().getIntExtra("key_position",0);

        if (test_position == 0){
            pdfView.fromAsset("first.pdf").load();
        }
        else if (test_position == 1){
            pdfView.fromAsset("second.pdf").load();
        }
    }
}