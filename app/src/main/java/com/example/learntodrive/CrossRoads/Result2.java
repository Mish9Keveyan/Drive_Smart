package com.example.learntodrive.CrossRoads;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.learntodrive.MainActivity;
import com.example.learntodrive.R;

public class Result2 extends AppCompatActivity {

    TextView txtCorrectText;
    TextView txtPercentText;
    private int totalQuestions;
    private int finalScore;
    private int PercentScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtCorrectText = findViewById(R.id.correct_textview);
        txtPercentText = findViewById(R.id.percent_textview);

        Intent intent = getIntent();
        totalQuestions = intent.getIntExtra("totalQuestions",0);
        finalScore = intent.getIntExtra("finalScore",0);

        PercentScore2 = finalScore * 100/ totalQuestions;

        txtPercentText.setText(String.format("%s%%",Integer.toString(Integer.valueOf(PercentScore2))));

        @SuppressLint("StringFormatMatches") String final_Score_Text = getString(R.string.txtCorrectScore,finalScore,totalQuestions);

        txtCorrectText.setText(final_Score_Text);

    }


    public void restartGame(View view) {
        Intent intent = new Intent(Result2.this, CrossRoads1.class);
        startActivity(intent);
        finish();
    }


    public void goToMenu(View view) {
        Intent intent = getIntent();
        String level = intent.getStringExtra("level2");
        if (level != null && level.equals("first1")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level11 = save.getInt("Level2", 1);
            if (!(level11 > 1) && PercentScore2 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level2", 2);
                editor.apply();
            }
        } else if (level != null && level.equals("second1")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level12 = save.getInt("Level2", 2);
            if (!(level12 > 2) && PercentScore2 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level2", 3);
                editor.apply();
            }
        } else if (level != null && level.equals("third1")) {
            SharedPreferences save= getSharedPreferences("Save", MODE_PRIVATE);
            final int level13 = save.getInt("Level2", 3);
            if (!(level13 > 3) && PercentScore2 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level2", 4);
                editor.apply();
            }
        } else if (level != null && level.equals("fourth1")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level14 = save.getInt("Level2", 4);
            if (!(level14 > 4) && PercentScore2 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level2", 5);
                editor.apply();
            }
        }

        startActivity(new Intent(Result2.this, CrossRoadsActivity.class));
        finish();
    }

}