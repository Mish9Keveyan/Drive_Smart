package com.example.learntodrive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPasword;
    private TextInputLayout textInputConfirmPasword;
    private AppCompatButton SignUpButton;
    private TextView toggleLoginSignUpTextView;
    private TextView tvYes;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputEmail = findViewById(R.id.textInputEmail);
        textInputName = findViewById(R.id.textInputName);
        textInputPasword = findViewById(R.id.textInputPassword);
        textInputConfirmPasword = findViewById(R.id.textInputConfirmPassword);
        SignUpButton = findViewById(R.id.SignUpButton);
        toggleLoginSignUpTextView = findViewById(R.id.toggleLoginSignUpTextView);
        tvYes = findViewById(R.id.tvYes);


        SignUpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                validateEmail();
            }
        });

    }
    private boolean validateEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()){
            textInputEmail.setError("Please, enter your Email");
            return false;
        }else {
            textInputEmail.setError("");
            return true;
        }
    }


    public void toggleLoginSignUp(View view) {
    }

    public void SignUpUser(View view) {
    }
}