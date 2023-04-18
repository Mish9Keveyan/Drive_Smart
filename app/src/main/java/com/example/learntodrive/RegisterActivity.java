package com.example.learntodrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;
    private AppCompatButton SignUpButton;
    private TextView toggleLoginSignUpTextView;
    private TextView tvYes;

    private boolean isLoginActivity;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;

    private ImageView google,facebook;

    private static final String TAG = "GoogleActivity";
    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

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

        mAuth = FirebaseAuth.getInstance();


        facebook = findViewById(R.id.facebook);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        google = findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
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

        String email = textInputEmail.getEditText().getText().toString().trim();
        String password = textInputPassword.getEditText().getText().toString().trim();
        if (!isLoginActivity) {
            if (validateEmail() & validateName() & validatePassword() & validateConfirmPassword()) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    String nameInput = textInputName.getEditText().getText().toString().trim();
                                    Toast.makeText(RegisterActivity.this, "Welcome " + nameInput, Toast.LENGTH_SHORT).show();
                                    Log.d("signup", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    database = FirebaseDatabase.getInstance();
                                    myRef = database.getReference("test");
                                    myRef.child("users").child(user.getUid()).child("username").setValue(nameInput);

                                    startActivity(new Intent(RegisterActivity.this,AccountActivity.class));
                                    finish();
                                } else {
                                    Log.w("signup", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                String nameInput = textInputName.getEditText().getText().toString().trim();
                Toast.makeText(this, "Welcome " + nameInput, Toast.LENGTH_SHORT).show();
            }
        } else {
            if (validateEmail() & validatePassword()) {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d("login", "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startActivity(new Intent(RegisterActivity.this,AccountActivity.class));
                                    finish();
                                } else {
                                    Log.w("login", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(RegisterActivity.this, "Неверный email или пароль",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            database = FirebaseDatabase.getInstance();
                            myRef = database.getReference("test");

                            myRef.child("users").child(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (!task.isSuccessful()){
                                        Log.e("firebase","Error getting data", task.getException());
                                    }else {
                                        Tools.NAME = String.valueOf(task.getResult().child("username").getValue());
                                        Log.d("firebase","Tools.NAME - " + Tools.NAME);
                                    }
                                }
                            });

                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            updateUI(null);
                        }
                    }
                });
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    private void updateUI(FirebaseUser user) {

        if(user != null){

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(RegisterActivity.this, AccountActivity.class);
                    startActivity(intent);
                    finish();
                }
            },200);
        }
    }
}