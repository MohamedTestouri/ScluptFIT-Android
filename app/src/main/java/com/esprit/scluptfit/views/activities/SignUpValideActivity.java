package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.esprit.scluptfit.R;

public class SignUpValideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_valide);
    }

    public void navigateToHome(View view) {
        startActivity(new Intent(SignUpValideActivity.this, HomeActivity.class));
    }
}