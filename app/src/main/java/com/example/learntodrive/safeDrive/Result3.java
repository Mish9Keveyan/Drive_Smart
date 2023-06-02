package com.example.learntodrive.safeDrive;

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
import com.example.learntodrive.Signs.FirstLevelActivity;
import com.example.learntodrive.Signs.FourthLevelActivity;
import com.example.learntodrive.Signs.ResultActivity;
import com.example.learntodrive.Signs.SecondLevelActivity;
import com.example.learntodrive.Signs.ThirdLevelActivity;
import com.example.learntodrive.TestOptionActivity;
import com.example.learntodrive.law.Result4;

public class Result3 extends AppCompatActivity {

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
        TextView uwu = findViewById(R.id.uwu);
        Button res = findViewById(R.id.b1);
        Button menu = findViewById(R.id.ktestam);

        Intent intent = getIntent();
        totalQuestions = intent.getIntExtra("totalQuestions",0);
        finalScore = intent.getIntExtra("finalScore",0);

        PercentScore2 = finalScore * 100/ totalQuestions;

        txtPercentText.setText(String.format("%s%%",Integer.toString(Integer.valueOf(PercentScore2))));

        @SuppressLint("StringFormatMatches") String final_Score_Text = getString(R.string.txtCorrectScore,finalScore,totalQuestions);

        txtCorrectText.setText(final_Score_Text);
        if (PercentScore2 > 69){
            menu.setBackgroundColor(getResources().getColor(R.color.Right));
            uwu.setText("Поздравляю, вы прошли!");
        }else {
            res.setBackgroundColor(getResources().getColor(R.color.Incorrect));
            uwu.setText("Вы не прошли тестирование");
        }
    }


    public void restartGame(View view) {
        Intent intent = getIntent();
        String level = intent.getStringExtra("level3");
        if (level != null && level.equals("first2")) {
            Intent intent_first = new Intent(Result3.this, SafeDrive1.class);
            startActivity(intent_first);
        } else if (level != null && level.equals("second2")) {
            Intent intent_second = new Intent(Result3.this, SafeDrive2.class);
            startActivity(intent_second);
        }else if (level != null && level.equals("third2")) {
            Intent intent_third = new Intent(Result3.this, SafeDrive3.class);
            startActivity(intent_third);
        }else if (level != null && level.equals("fourth2")) {
            Intent intent_third = new Intent(Result3.this, SafeDrive4.class);
            startActivity(intent_third);
        }
        finish();
    }

    public void goToMenu(View view) {
        Intent intent = getIntent();
        String level = intent.getStringExtra("level3");
        if (level != null && level.equals("first2")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level11 = save.getInt("Level3", 1);
            if (!(level11 > 1) && PercentScore2 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level3", 2);
                editor.apply();
            }
        } else if (level != null && level.equals("second2")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level12 = save.getInt("Level3", 2);
            if (!(level12 > 2) && PercentScore2 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level3", 3);
                editor.apply();
            }
        } else if (level != null && level.equals("third2")) {
            SharedPreferences save= getSharedPreferences("Save", MODE_PRIVATE);
            final int level13 = save.getInt("Level3", 3);
            if (!(level13 > 3) && PercentScore2 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level3", 4);
                editor.apply();
            }
        } else if (level != null && level.equals("fourth2")) {
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level14 = save.getInt("Level3", 4);
            if (!(level14 > 4) && PercentScore2 > 69) {
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level3", 5);
                editor.apply();
            }
        }
        startActivity(new Intent(Result3.this, TestOptionActivity.class));
        finish();
    }
}