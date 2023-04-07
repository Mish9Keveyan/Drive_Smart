package com.example.learntodrive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;
    private AppCompatButton SignUpButton;
    private TextView toggleLoginSignUpTextView;
    private TextView tvYes;

    private boolean isLoginActivity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputEmail = findViewById(R.id.textInputEmail);
        textInputName = findViewById(R.id.textInputName);
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputConfirmPassword = findViewById(R.id.textInputConfirmPassword);
        SignUpButton = findViewById(R.id.SignUpButton);
        toggleLoginSignUpTextView = findViewById(R.id.toggleLoginSignUpTextView);
        tvYes = findViewById(R.id.tvYes);


    }
    private boolean validateEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()){
            textInputEmail.setError("Please, enter your Email");
            return false;
        } else if (countAtSymbols(emailInput) != 1) {
            textInputEmail.setError("Please, enter valid Email");
            return false;
        } else if (checkStringDoubleDot(emailInput)) {
            textInputEmail.setError("Please, enter valid Email");
            return false;
        } else if (checkStringSpace(emailInput)) {
            textInputEmail.setError("Please, enter valid Email");
            return false;
        } else {
            textInputEmail.setError("");
            return true;
        }
    }
    private boolean validateName(){
        String nameInput = textInputName.getEditText().getText().toString().trim();
        if (nameInput.isEmpty()){
            textInputName.setError("Please, enter your Name");
            return false;
        }else {
            textInputName.setError("");
            return true;
        }
    }
    private boolean validatePassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty()){
            textInputPassword.setError("Please, enter your password");
            return false;
        } else if (passwordInput.length() < 6) {
            textInputPassword.setError("Length of password must be 6 characters or more");
            return false;
        } else {
            textInputPassword.setError("");
            return true;
        }
    }


    private boolean validateConfirmPassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();
        String confirmpasswordInput = textInputConfirmPassword.getEditText().getText().toString().trim();
        if (confirmpasswordInput.isEmpty()){
            textInputConfirmPassword.setError("Please, enter your second password");
            return false;
        }else if (confirmpasswordInput.length() < 6) {
            textInputConfirmPassword.setError("Length of password must be 6 characters or more");
            return false;
        } else if (!confirmpasswordInput.equals(passwordInput)) {
            textInputConfirmPassword.setError("Password is different");
            return false;
        } else {
            textInputConfirmPassword.setError("");
            return true;
        }
    }




    public void toggleLoginSignUp(View view) {
        if (isLoginActivity){
            isLoginActivity = false;
            textInputName.setVisibility(View.VISIBLE);
            textInputConfirmPassword.setVisibility(View.VISIBLE);
            toggleLoginSignUpTextView.setText(R.string.toggleLoginSignUpTextView);
            SignUpButton.setText("Создать Aккаунт");
        }else {
            isLoginActivity = true;
            textInputName.setVisibility(View.GONE);
            textInputConfirmPassword.setVisibility(View.GONE);
            toggleLoginSignUpTextView.setText("Создать новый аккаунт?");
            SignUpButton.setText("Bойти");
        }
    }

    public void SignUpUser(View view) {
        if (validateEmail() & validateName() & validatePassword() & validateConfirmPassword()){
            String nameInput = textInputName.getEditText().getText().toString().trim();
            Toast.makeText(this, "Welcome " + nameInput, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        }
    }
    public static int countAtSymbols(String inputString) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '@') {
                count++;
            }
        }
        return count;
    }

    public boolean checkStringDoubleDot(String input){
        return input.contains("..");
    }
    public boolean checkStringSpace(String input){
        return input.contains(" ");
    }
}
