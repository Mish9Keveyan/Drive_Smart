package com.example.learntodrive.Signs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.learntodrive.R;

public class ResultActivity1 extends AppCompatActivity {

    TextView txtCorrectText;
    TextView txtPercentText;
    private int totalQuestions;
    private int finalScore;
    private int PercentScore1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtCorrectText = findViewById(R.id.correct_textview);
        txtPercentText = findViewById(R.id.percent_textview);

        Intent intent = getIntent();
        totalQuestions = intent.getIntExtra("totalQuestions",0);
        finalScore = intent.getIntExtra("finalScore",0);

        PercentScore1 = finalScore * 100/ totalQuestions;

        txtPercentText.setText(String.format("%s%%",Integer.toString(Integer.valueOf(PercentScore1))));

        @SuppressLint("StringFormatMatches") String final_Score_Text = getString(R.string.txtCorrectScore,finalScore,totalQuestions);

        txtCorrectText.setText(final_Score_Text);

    }


    public void restartGame(View view) {
        Intent intent = getIntent();
        String level = intent.getStringExtra("level");
        if (level != null && level.equals("first")) {
            Intent intent_first = new Intent(ResultActivity1.this, FirstLevelActivity.class);
            startActivity(intent_first);
        } else if (level != null && level.equals("second")) {
            Intent intent_second = new Intent(ResultActivity1.this, SecondLevelActivity.class);
            startActivity(intent_second);
        }
        finish();
    }
    public void goToMenu(View view) {
        Intent intent = getIntent();
        String level = intent.getStringExtra("level");
        if (level != null && level.equals("first")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level1 = save.getInt("Level", 1);
            if (!(level1 > 1) && PercentScore1 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level", 2);
                editor.commit();
            }
            super.onBackPressed();
        }
        if (level != null && level.equals("second")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level2 = save.getInt("Level", 2);
            if (!(level2 > 2) && PercentScore1 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level", 3);
                editor.commit();
            }
            super.onBackPressed();
        }
    }
}