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

import androidx.appcompat.app.AppCompatActivity;

import com.example.learntodrive.Questions;
import com.example.learntodrive.R;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ThirdLevelActivity extends AppCompatActivity {
    final RadioButton[] rb3 = new RadioButton[3];
    private ImageView bTestImage;
    private String bAnswer;
    private int correctAnswerIndex;
    private int bScore = 0;
    private int bTestNum = 1;
    private int QuestionNum = 0;
    private TextView bQuestionView;
    private TextView bTestNumView;
    private Questions Questions3 = new Questions();
    String Coorectanswers3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signs_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        bQuestionView = findViewById(R.id.question_textview);
        bTestNumView = findViewById(R.id.quiznum);

        updateQuestion();

        Button next = findViewById(R.id.button_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnyRadioButtonNotEmpty = false;
                for (RadioButton rb : rb3) {
                    if (rb.isChecked()){
                        isAnyRadioButtonNotEmpty = true;
                        break;
                    }
                }
                if(isAnyRadioButtonNotEmpty){
                    if (Questions3.getType3(QuestionNum) == "radiobutton") {
                        next.setVisibility(View.GONE);
                        if (Questions3.getCoorectAnswers3(QuestionNum).equals(bAnswer)) {
                            bScore++;
                        }
                    }
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (QuestionNum == Questions3.getLenght3() - 1) {
                                Intent intent_result = new Intent(ThirdLevelActivity.this, ResultActivity.class);
                                intent_result.putExtra("totalQuestions", Questions3.getLenght3());
                                intent_result.putExtra("finalScore", bScore);
                                intent_result.putExtra("level", "third");
                                startActivity(intent_result);
                                QuestionNum = 0;
                                bScore = 0;
                                bTestNum = 1;
                                finish();
                            }else {
                                QuestionNum++;
                                bTestNum++;
                                updateQuestion();
                            }
                        }
                    },550);
                }else {
                    Toast.makeText(ThirdLevelActivity.this, "Выберите правильный ответ", Toast.LENGTH_SHORT).show();
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
        bAnswer="";
        findViewById(R.id.button_next).setBackgroundColor(findViewById(R.id.button_next).getContext().getResources().getColor(R.color.bg_color));
        bTestNumView.setText(bTestNum + "/" + String.valueOf(Questions3.getLenght3()));
        bQuestionView.setText(Questions3.getQuestions3(QuestionNum));
        if(Questions3.getType3(QuestionNum) == "radiobutton"){
            showRadioButtonAnswers(QuestionNum);
            findViewById(R.id.button_next).setVisibility(View.VISIBLE);
        }
        showMainImage();
    }
    private void showMainImage(){
        bTestImage = findViewById(R.id.question_image);
        String imgUrl = Questions3.getImages3(QuestionNum);
        Picasso.get().load(imgUrl).into(bTestImage);
    }
    private void showRadioButtonAnswers(int anum){
        final LinearLayout answerLayout = findViewById(R.id.answers_layout);
        RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        rg.setLayoutParams(lp);
        rg.setPadding(25, 100, 55, 0);


        View topLineView = new View(this);
        topLineView.setBackgroundColor(Color.BLACK);
        LinearLayout.LayoutParams topLineParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2
        );
        topLineView.setLayoutParams(topLineParams);
        rg.addView(topLineView, 0);


        for (int i = 0; i <= 2; i++) {
            rb3[i] = new RadioButton(this);
            rb3[i].setText(Questions3.getChoice3(anum) [i]);
            rb3[i].setTextColor(Color.BLACK);
            rb3[i].setPadding(10,70,8,70);
            rb3[i].setTextSize(16);
            rb3[i].setId(i);
            rb3[i].setWidth(1000);
            rg.addView(rb3[i]);
            View lineView = new View(this);
            lineView.setBackgroundColor(Color.BLACK);
            LinearLayout.LayoutParams lineParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2);
            lineView.setLayoutParams(lineParams);
            rg.addView(lineView);
            if (Questions3.getCoorectAnswers3(anum).equals(Questions3.getChoice3(anum)[i])){
                correctAnswerIndex = i;
            }
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int Id) {
                bAnswer = Questions3.getChoice3(QuestionNum)[Id];
                displayCorrectAnswer();
            }
        });
        answerLayout.addView(rg);
    }

    private void displayCorrectAnswer() {
        for (int i = 0; i < rb3.length; i++) {
            rb3[i].setEnabled(false);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < rb3.length; i++) {
                    if (Questions3.getCoorectAnswers3(QuestionNum).equals(rb3[i].getText())) {
                        rb3[i].setButtonTintList(ColorStateList.valueOf(Color.GREEN));
                        if (rb3[i].isChecked()) {
                            displayToastCorrectAnswer();
                            rb3[i].setBackgroundResource(R.color.Right);
                            rb3[i].setTextColor(getResources().getColor(R.color.white));
                        }
                    } else {
                        if (rb3[i].isChecked()) {
                            displayToastWrongAnswer();
                            rb3[i].setButtonTintList(ColorStateList.valueOf(Color.RED));
                            rb3[i].setBackgroundResource(R.color.Incorrect);
                            rb3[i].setTextColor(getResources().getColor(R.color.white));
                        }
                    }
                }
            }
        }, 550);
    }
}