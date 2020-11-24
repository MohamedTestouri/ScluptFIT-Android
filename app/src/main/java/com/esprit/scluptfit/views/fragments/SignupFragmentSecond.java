package com.esprit.scluptfit.views.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.services.UserService;
import com.esprit.scluptfit.views.activities.SignUpValideActivity;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignupFragmentSecond extends Fragment {
    private TextInputLayout email;
    private TextInputLayout password;
    private TextInputLayout confirmPassword;
    private Button signupButton;
    private UserService userService = new UserService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_second, container, false);
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
                    try {
                        String fullName = getArguments().getString("fullName");
                        String phone = getArguments().getString("phone");
                        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(getArguments().getString("birthday"));
                        String gender = getArguments().getString("gender");
                        User user = new User(fullName, phone, birthday, gender, password.getEditText().getText().toString(), email.getEditText().getText().toString());
                        userService.Signup(user);
                        showFragment("5fbc3f70fe7d384680a9f1fe");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return rootView;
    }

    public void showFragment(String idUser) {
        Fragment fragment = new SignupFragmentThird();
        Bundle data = new Bundle();
        data.putString("idUser", idUser        );
        fragment.setArguments(data);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
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