package com.example.learntodrive.Signs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learntodrive.MainActivity;
import com.example.learntodrive.R;
import com.example.learntodrive.TestOptionActivity;
import com.example.learntodrive.law.Result4;

public class ResultActivity extends AppCompatActivity {

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
        TextView uwu = findViewById(R.id.uwu);
        Button res = findViewById(R.id.b1);
        Button menu = findViewById(R.id.ktestam);

        Intent intent = getIntent();
        totalQuestions = intent.getIntExtra("totalQuestions",0);
        finalScore = intent.getIntExtra("finalScore",0);

        PercentScore1 = finalScore * 100/ totalQuestions;

        txtPercentText.setText(String.format("%s%%",Integer.toString(Integer.valueOf(PercentScore1))));

        @SuppressLint("StringFormatMatches") String final_Score_Text = getString(R.string.txtCorrectScore,finalScore,totalQuestions);

        txtCorrectText.setText(final_Score_Text);

        if (PercentScore1 > 69){
            menu.setBackgroundColor(getResources().getColor(R.color.Right));
            uwu.setText("Поздравляю, вы прошли!");
        }else {
            res.setBackgroundColor(getResources().getColor(R.color.Incorrect));
            uwu.setText("Вы не прошли тестирование");
        }
    }


    public void restartGame(View view) {
        Intent intent = getIntent();
        String level = intent.getStringExtra("level");
        if (level != null && level.equals("first")) {
            Intent intent_first = new Intent(ResultActivity.this, FirstLevelActivity.class);
            startActivity(intent_first);
        } else if (level != null && level.equals("second")) {
            Intent intent_second = new Intent(ResultActivity.this, SecondLevelActivity.class);
            startActivity(intent_second);
        }else if (level != null && level.equals("third")) {
            Intent intent_third = new Intent(ResultActivity.this, ThirdLevelActivity.class);
            startActivity(intent_third);
        }else if (level != null && level.equals("fourth")) {
            Intent intent_third = new Intent(ResultActivity.this, FourthLevelActivity.class);
            startActivity(intent_third);
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
            startActivity(new Intent(ResultActivity.this, TestOptionActivity.class));
            finish();
        }
        if (level != null && level.equals("second")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level2 = save.getInt("Level", 2);
            if (!(level2 > 2) && PercentScore1 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level", 3);
                editor.commit();
            }
            startActivity(new Intent(ResultActivity.this, TestOptionActivity.class));
            finish();
        }
        if (level != null && level.equals("third")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level3 = save.getInt("Level", 3);
            if (!(level3 > 3) && PercentScore1 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level", 4);
                editor.commit();
            }
            startActivity(new Intent(ResultActivity.this, TestOptionActivity.class));
            finish();
        }
        if (level != null && level.equals("fourth")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level4 = save.getInt("Level", 4);
            if (!(level4 > 4) && PercentScore1 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level", 5);
                editor.commit();
            }
            startActivity(new Intent(ResultActivity.this, TestOptionActivity.class));
            finish();
        }
    }
}