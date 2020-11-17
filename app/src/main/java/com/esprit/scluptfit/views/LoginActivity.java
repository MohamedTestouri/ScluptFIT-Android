package com.esprit.scluptfit.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.esprit.scluptfit.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextInputLayout email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void SignUp(View view) {
        Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

    private  Boolean validatEmail(){
        email=(TextInputLayout) findViewById(R.id.email);
        String val=email.getEditText().getText().toString();

        if (val.isEmpty()){
            email.setError("Field cannot be empty");
            return false;
        }else {
            email.setError(null);
            email.setErrorEnabled(false);
            return  true;
        }

    }

    private  Boolean validatPassword(){
        password=(TextInputLayout) findViewById(R.id.password);
        String val=password.getEditText().getText().toString();

        if (val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        }else {
            password.setError(null);
            password.setErrorEnabled(false);
            return  true;
        }

    }

    public  void loginUser(View view){
        if (!validatEmail() | !validatPassword()){
            return;
        } else {
            isUser();
        }
    }



   public void isUser() {
        email=(TextInputLayout) findViewById(R.id.email);
        password=(TextInputLayout) findViewById(R.id.password);

        String userEnteredUsername=email.getEditText().getText().toString().trim();
        String userEnteredPassword=password.getEditText().getText().toString().trim();

        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
    }
}