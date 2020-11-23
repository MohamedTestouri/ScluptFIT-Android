package com.esprit.scluptfit.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.esprit.scluptfit.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignupFragmentSecond extends Fragment {
    private TextInputLayout weight;
    private TextInputLayout height;
    private Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_second, container, false);
        weight = rootView.findViewById(R.id.weight);
        height = rootView.findViewById(R.id.height);
        nextButton = rootView.findViewById(R.id.nextStepButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateTextInput(height) | !validateTextInput(weight)) {
                    return;
                } else {
                    Fragment fragment = new SignupFragmentThird();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, fragment).commit();
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