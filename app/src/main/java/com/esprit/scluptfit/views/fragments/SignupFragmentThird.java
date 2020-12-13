package com.esprit.scluptfit.views.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.services.UserService;
import com.esprit.scluptfit.views.activities.SignUpValideActivity;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;

public class SignupFragmentThird extends Fragment {
    private TextInputLayout weight;
    private TextInputLayout height;
    private Button nextButton;
    private UserService userService = new UserService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_third, container, false);
        weight = rootView.findViewById(R.id.weight);
        height = rootView.findViewById(R.id.height);
        nextButton = rootView.findViewById(R.id.nextStepButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateTextInput(height) | !validateTextInput(weight)) {
                    return;
                } else {
                    double weightInformation = Double.valueOf(weight.getEditText().getText().toString());
                    double heightInformation = Double.valueOf(height.getEditText().getText().toString());
                    User.HealthInformation healthInformation = new User.HealthInformation(0.0, weightInformation, heightInformation, 0);
                    userService.addHealthInformation(getContext(), healthInformation);

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