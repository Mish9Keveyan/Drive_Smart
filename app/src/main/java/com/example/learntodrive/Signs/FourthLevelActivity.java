package com.example.learntodrive.Signs;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;


import androidx.appcompat.app.AppCompatActivity;

import com.example.learntodrive.Questions;
import com.example.learntodrive.R;
import com.squareup.picasso.Picasso;

public class FourthLevelActivity extends AppCompatActivity {

    final RadioButton[] rb4 = new RadioButton[2];
    private ImageView vTestImage;

    private String vAnswer;
    private int correctAnswerIndex;

    private int vScore = 0;
    private int vTestNum = 1;
    private int QuestionNum = 0;
    private TextView vQuestionView;
    private TextView vTestNumView;

    private Questions Questions4 = new Questions();
    String Coorectanswers4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signs_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        vQuestionView = findViewById(R.id.question_textview);
        vTestNumView = findViewById(R.id.quiznum);

        updateQuestion();

        Button next = findViewById(R.id.button_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnyRadioButtonNotEmpty = false;
                for (RadioButton rb : rb4) {
                    if (rb.isChecked()) {
                        isAnyRadioButtonNotEmpty = true;
                        break;
                    }
                }
                if (isAnyRadioButtonNotEmpty) {
                    if (Questions4.getType4(QuestionNum) == "radiobutton") {
                        next.setVisibility(View.GONE);
                        if (Questions4.getCoorectAnswers4(QuestionNum).equals(vAnswer)) {
                            vScore++;
                        }
                    }
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (QuestionNum == Questions4.getLenght4() - 1) {
                                Intent intent_result = new Intent(FourthLevelActivity.this, ResultActivity.class);
                                intent_result.putExtra("totalQuestions", Questions4.getLenght4());
                                intent_result.putExtra("finalScore", vScore);
                                intent_result.putExtra("level", "fourth");
                                startActivity(intent_result);
                                QuestionNum = 0;
                                vScore = 0;
                                vTestNum = 1;
                                finish();
                            } else {
                                QuestionNum++;
                                vTestNum++;
                                updateQuestion();
                            }
                        }
                    },550);
                }else {
                    Toast.makeText(FourthLevelActivity.this, "Выберите правильный ответ", Toast.LENGTH_SHORT).show();
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
        vAnswer="";
        findViewById(R.id.button_next).setBackgroundColor(findViewById(R.id.button_next).getContext().getResources().getColor(R.color.bg_color));

        vTestNumView.setText(vTestNum + "/" + String.valueOf(Questions4.getLenght4()));
        vQuestionView.setText(Questions4.getQuestions4(QuestionNum));

        if (Questions4.getType4(QuestionNum).equals("radiobutton")){
            findViewById(R.id.button_next).setVisibility(View.VISIBLE);
            showRadioButtonAnswers(QuestionNum);
        }

        showMainImage();

    }

    private void showMainImage(){
        vTestImage = findViewById(R.id.question_image);

        String imgUrl = Questions4.getImages4(QuestionNum);

        Picasso.get().load(imgUrl).into(vTestImage);
    }

    private void showRadioButtonAnswers(int snum){

        final LinearLayout answerLayout = findViewById(R.id.answers_layout);

        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(RadioGroup.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        rg.setLayoutParams(lp);
        rg.setPadding(25, 130, 55, 0);
        View topLineView = new View(this);
        topLineView.setBackgroundColor(Color.BLACK);
        LinearLayout.LayoutParams topLineParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2
        );
        topLineView.setLayoutParams(topLineParams);
        rg.addView(topLineView, 0);

        for (int i = 0; i <= 1; i++) {
            rb4[i] = new RadioButton(this);
            rb4[i].setText(Questions4.getChoice4(snum)[i]);
            rb4[i].setTextColor(Color.BLACK);
            rb4[i].setPadding(10,100,8,100);
            rb4[i].setTextSize(19);
            rb4[i].setId(i);
            rb4[i].setWidth(1000);
            rg.addView(rb4[i]);
            View lineView = new View(this);
            lineView.setBackgroundColor(Color.BLACK);
            LinearLayout.LayoutParams lineParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2);
            lineView.setLayoutParams(lineParams);
            rg.addView(lineView);

            if (Questions4.getCoorectAnswers4(snum).equals(Questions4.getChoice4(snum)[i])) {
                correctAnswerIndex = i;
            }
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int Id) {
                vAnswer = Questions4.getChoice4(QuestionNum)[Id];
                displayCorrectAnswer();
            }
        });
        answerLayout.addView(rg);
    }
    private void displayCorrectAnswer() {
        for (int i = 0; i < rb4.length; i++) {
            rb4[i].setEnabled(false);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < rb4.length; i++) {
                    if (Questions4.getCoorectAnswers4(QuestionNum).equals(rb4[i].getText())) {
                        rb4[i].setButtonTintList(ColorStateList.valueOf(Color.GREEN));
                        if (rb4[i].isChecked()) {
                            rb4[i].setBackgroundResource(R.color.Right);
                            rb4[i].setTextColor(getResources().getColor(R.color.white));
                            displayToastCorrectAnswer();
                        }
                    } else {
                        if (rb4[i].isChecked()) {
                            rb4[i].setButtonTintList(ColorStateList.valueOf(Color.RED));
                            rb4[i].setBackgroundResource(R.color.Incorrect);
                            rb4[i].setTextColor(getResources().getColor(R.color.white));
                            displayToastWrongAnswer();
                        }
                    }
                }
            }
        }, 550);
    }
}