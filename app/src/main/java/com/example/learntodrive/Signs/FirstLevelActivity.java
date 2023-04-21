package com.example.learntodrive.Signs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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
import com.example.learntodrive.ResultActivity;

public class FirstLevelActivity extends AppCompatActivity {

    final RadioButton[] rb1 = new RadioButton[3];
    private ImageView mTestImage;

    private String mAnswer;
    private int correctAnswerIndex;

    private int mScore = 0;
    private int mTestNum = 1;
    private int QuestionNum = 0;
    private TextView mQuestionView;
    private TextView mTestNumView;

    private Questions Questions1 = new Questions();
    String Coorectanswers1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signs_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        mQuestionView = findViewById(R.id.question_textview);
        mTestNumView = findViewById(R.id.quiznum);

        updateQuestion();

        Button next = findViewById(R.id.button_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Questions1.getType1(QuestionNum) == "radiobutton"){
                    if(Questions1.getCoorectAnswers1(QuestionNum).equals(mAnswer)){
                        mScore++;
                        displayToastCorrectAnswer();
                        rb1[correctAnswerIndex].setButtonTintList(ColorStateList.valueOf(Color.GREEN));
                    }else {
                        rb1[correctAnswerIndex].setButtonTintList(ColorStateList.valueOf(Color.GREEN));
                        for (int i = 0; i < rb1.length; i++) {
                            if (!Questions1.getCoorectAnswers1(QuestionNum).equals(rb1[i].getText())) {
                                rb1[i].setButtonTintList(ColorStateList.valueOf(Color.RED));
                            }
                        }
                        displayToastWrongAnswer();
                    }
                }
                SystemClock.sleep(1000);

                if (QuestionNum == Questions1.getLenght1() - 1){

                    Intent intent_result = new Intent(FirstLevelActivity.this, ResultActivity.class);
                    intent_result.putExtra("totalQuestions",Questions1.getLenght1());
                    intent_result.putExtra("finalScore",mScore);
                    startActivity(intent_result);

                    QuestionNum = 0;
                    mScore = 0;
                    mTestNum = 1;
                }else {

                    QuestionNum++;
                    mTestNum++;
                }

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQuestion();
                    }
                },1000);


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
        mAnswer="";
        findViewById(R.id.button_next).setBackgroundColor(findViewById(R.id.button_next).getContext().getResources().getColor(R.color.bg_color));

        mTestNumView.setText(mTestNum + "/" + String.valueOf(Questions1.getLenght1()));
        mQuestionView.setText(Questions1.getQuestions1(QuestionNum));

        if (Questions1.getType1(QuestionNum) == "radiobutton"){

            showRadioButtonAnswers(QuestionNum);
        }

        showMainImage();

        ScrollView sv = findViewById(R.id.scrollView);

        sv.smoothScrollTo(0,0);

    }

    private void showMainImage(){
        mTestImage = findViewById(R.id.question_image);

        String img = Questions1.getImages1(QuestionNum);

        mTestImage.setImageResource(getResources().getIdentifier(img,"drawable",getPackageName()));
    }

    private int showRadioButtonAnswers(int qnum){



        final LinearLayout answerLayout = findViewById(R.id.answers_layout);

        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(RadioGroup.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        rg.setLayoutParams(lp);
        rg.setPadding(90,0,0,0);



        for (int i = 0; i <= 2; i++) {

            rb1[i] = new RadioButton(this);
            rb1[i].setText(Questions1.getChoice1(qnum) [i]);
            rb1[i].setTextColor(Color.BLACK);
            rb1[i].setPadding(10,66,8,66);
            rb1[i].setTextSize(20);
            rb1[i].setId(i);
            rb1[i].setWidth(1000);
            rg.addView(rb1[i]);
            if (Questions1.getCoorectAnswers1(qnum).equals(Questions1.getChoice1(qnum)[i])) {
                correctAnswerIndex = i;
            }
        }

      rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup radioGroup, int Id) {
              mAnswer = Questions1.getChoice1(QuestionNum)[Id];

          }
      });
        answerLayout.addView(rg);


        return qnum;
    }
}