package com.example.learntodrive.Signs;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learntodrive.Questions;
import com.example.learntodrive.R;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class SecondLevelActivity extends AppCompatActivity {
    final RadioButton[] rb2 = new RadioButton[3];
    private ImageView nTestImage;
    private String nAnswer;
    private int correctAnswerIndex;
    private int nScore = 0;
    private int nTestNum = 1;
    private int QuestionNum = 0;
    private TextView nQuestionView;
    private TextView nTestNumView;
    private Questions Questions2 = new Questions();
    String Coorectanswers2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signs_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        nQuestionView = findViewById(R.id.question_textview);
        nTestNumView = findViewById(R.id.quiznum);

        updateQuestion();

        Button next = findViewById(R.id.button_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnyRadioButtonNotEmpty = false;
                for (RadioButton rb : rb2) {
                    if (rb.isChecked()){
                        isAnyRadioButtonNotEmpty = true;
                        break;
                    }
                }
                if(isAnyRadioButtonNotEmpty){
                    if (Questions2.getType2(QuestionNum) == "radiobutton"){
                        next.setVisibility(View.GONE);
                        if(Questions2.getCoorectAnswers2(QuestionNum).equals(nAnswer)){
                            nScore++;
                            displayToastCorrectAnswer();
                            rb2[correctAnswerIndex].setButtonTintList(ColorStateList.valueOf(Color.GREEN));
                        } else {
                            rb2[correctAnswerIndex].setButtonTintList(ColorStateList.valueOf(Color.GREEN));
                            for (int i = 0;i < rb2.length; i++){
                                if (!Questions2.getCoorectAnswers2(QuestionNum).equals(rb2[i].getText())){
                                    rb2[i].setButtonTintList(ColorStateList.valueOf(Color.RED));
                                }
                            }
                            displayToastWrongAnswer();
                        }
                    }
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (QuestionNum == Questions2.getLenght2() - 1) {
                                Intent intent_result = new Intent(SecondLevelActivity.this, ResultActivity1.class);
                                intent_result.putExtra("totalQuestions", Questions2.getLenght2());
                                intent_result.putExtra("finalScore", nScore);
                                intent_result.putExtra("level", "second");
                                startActivity(intent_result);
                                QuestionNum = 0;
                                nScore = 0;
                                nTestNum = 1;
                                finish();
                            }else {
                                QuestionNum++;
                                nTestNum++;
                                updateQuestion();
                            }
                        }
                    },1700);
                }else {
                    Toast.makeText(SecondLevelActivity.this, "Выберите правильный ответ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.imageViewQuizOption).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void displayToastCorrectAnswer(){
        Toast.makeText(this, "Правильно", Toast.LENGTH_SHORT).show();
    }
    private void displayToastWrongAnswer(){
        Toast.makeText(this, "Неверно", Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion(){
        LinearLayout answer_layout = findViewById(R.id.answers_layout);
        answer_layout.removeAllViews();
        nAnswer="";
        findViewById(R.id.button_next).setBackgroundColor(findViewById(R.id.button_next).getContext().getResources().getColor(R.color.bg_color));
        nTestNumView.setText(nTestNum + "/" + String.valueOf(Questions2.getLenght2()));
        nQuestionView.setText(Questions2.getQuestions2(QuestionNum));
        if(Questions2.getType2(QuestionNum) == "radiobutton"){
            showRadioButtonAnswers(QuestionNum);
            findViewById(R.id.button_next).setVisibility(View.VISIBLE);
        }
        showMainImage();
    }
    private void showMainImage(){
        nTestImage = findViewById(R.id.question_image);
        String imgUrl = Questions2.getImages2(QuestionNum);
        Picasso.get().load(imgUrl).into(nTestImage);
    }
    private int showRadioButtonAnswers(int wnum){
        final LinearLayout answerLayout = findViewById(R.id.answers_layout);
        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        rg.setLayoutParams(lp);
        rg.setPadding(40, 100, 20, 0);


        View topLineView = new View(this);
        topLineView.setBackgroundColor(Color.BLACK);
        LinearLayout.LayoutParams topLineParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2
        );
        topLineView.setLayoutParams(topLineParams);
        rg.addView(topLineView, 0);


        for (int i = 0; i <= 2; i++) {
            rb2[i] = new RadioButton(this);
            rb2[i].setText(Questions2.getChoice2(wnum) [i]);
            rb2[i].setTextColor(Color.BLACK);
            rb2[i].setPadding(10,70,8,70);
            rb2[i].setTextSize(16);
            rb2[i].setId(i);
            rb2[i].setWidth(1000);
            rg.addView(rb2[i]);
            View lineView = new View(this);
            lineView.setBackgroundColor(Color.BLACK);
            LinearLayout.LayoutParams lineParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2);
            lineView.setLayoutParams(lineParams);
            rg.addView(lineView);
            if (Questions2.getCoorectAnswers2(wnum).equals(Questions2.getChoice2(wnum)[i])){
                correctAnswerIndex = i;
            }
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int Id) {
                nAnswer = Questions2.getChoice2(QuestionNum)[Id];
            }
        });
        answerLayout.addView(rg);
        return wnum;
    }
}
