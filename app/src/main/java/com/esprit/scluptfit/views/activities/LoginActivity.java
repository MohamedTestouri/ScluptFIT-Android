package com.esprit.scluptfit.views.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.services.UserService;
import com.esprit.scluptfit.views.fragments.ProfileFragment;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout email;
    private TextInputLayout password;
    private Button loginButton;
    private Button signupButton;
    private UserService userService = new UserService();

    SharedPreferences sp;
    Intent intent;
    public final static String PREFS = "Settings";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupButton);
        loginButton.setOnClickListener(l -> {
            loginUser();
        });
        signupButton.setOnClickListener(l -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        });

    }


    private Boolean validateTextInput(TextInputLayout textInput) {
        String val = textInput.getEditText().getText().toString();
        if (val.isEmpty()) {
            textInput.setError("Field cannot be empty");
            return false;
        } else {
            textInput.setError(null);
            textInput.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser() {
        if (!validateTextInput(email) | !validateTextInput(password)) {
            return;
        } else {
            userService.Login(LoginActivity.this, email.getEditText().getText().toString(), password.getEditText().getText().toString());
            /*sp.edit().putBoolean("isLogged",true).apply();
            sp.edit().putString("mail", String.valueOf(email)).apply();
            intent = new Intent(LoginActivity.this, ProfileFragment.class);
            startActivity(intent);
            finish();*/

        }
    }

}