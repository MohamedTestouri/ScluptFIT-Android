package com.esprit.scluptfit.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.esprit.scluptfit.R;
import com.google.android.material.textfield.TextInputLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SignupFragmentFirst extends Fragment {
    private TextInputLayout firstName;
    private TextInputLayout lastName;
    private TextInputLayout phone;
    private Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_signup_first, container, false);
        firstName = rootView.findViewById(R.id.firstName);
        lastName = rootView.findViewById(R.id.lastName);
        phone = rootView.findViewById(R.id.phone);
        nextButton = rootView.findViewById(R.id.NextStep);
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateTextInput(firstName) | !validateTextInput(lastName) | !validateTextInput(phone)) {
                    return;
                } else {
                    Fragment fragment = new SignupFragmentSecond();
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