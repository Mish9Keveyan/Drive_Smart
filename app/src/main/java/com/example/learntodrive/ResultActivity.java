package com.example.learntodrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.learntodrive.Signs.FirstLevelActivity;
import com.example.learntodrive.Signs.TrafficSignsActivity;

public class ResultActivity extends AppCompatActivity {

    TextView txtCorrectText;
    TextView txtPercentText;
    private int totalQuestions;
    private int finalScore;
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

        int PercentScore1 = finalScore * 100/ totalQuestions;

        txtPercentText.setText(String.format("%s%%",Integer.toString(Integer.valueOf(PercentScore1))));

        String final_Score_Text = getString(R.string.txtCorrectScore,finalScore,totalQuestions);

        txtCorrectText.setText(final_Score_Text);

    }


    public void restartGame(View view) {

        startActivity(new Intent(ResultActivity.this, FirstLevelActivity.class));
        finish();
    }
    public void goToMenu(View view) {
        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level",1);
        if (level > 1) {
            //jhjh
        }else {
            SharedPreferences.Editor editor = save.edit();
            editor.putInt("Level",2);
            editor.commit();
        }
        super.onBackPressed();
    }
}