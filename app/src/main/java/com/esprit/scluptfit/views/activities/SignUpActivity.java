package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.views.fragments.SignupFragmentFirst;
import com.esprit.scluptfit.views.fragments.SignupFragmentThird;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new SignupFragmentFirst()).commit();
    }

    public void SignUp(View view) {
    }
}