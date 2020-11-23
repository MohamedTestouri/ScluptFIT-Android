package com.esprit.scluptfit.views.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.views.activities.SignUpValideActivity;
import com.google.android.material.textfield.TextInputLayout;

public class SignupFragmentThird extends Fragment {
    private TextInputLayout email;
    private TextInputLayout password;
    private TextInputLayout confirmPassword;
    private Button signupButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_third, container, false);
        email = rootView.findViewById(R.id.email);
        password = rootView.findViewById(R.id.password);
        confirmPassword = rootView.findViewById(R.id.confirmPassword);
        signupButton = rootView.findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateTextInput(email) | !validateTextInput(password) | !validateTextInput(confirmPassword)) {
                    return;
                } else if (!password.getEditText().getText().toString().equals(confirmPassword.getEditText().getText().toString())) {
                    Toast.makeText(getContext(), "Password doesn't match ! TRY AGAIN!", Toast.LENGTH_LONG).show();
                    password.getEditText().getText().clear();
                    confirmPassword.getEditText().getText().clear();
                } else {
                    startActivity(new Intent(getContext(), SignUpValideActivity.class));
                }
            }
        });
        return rootView;
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
}