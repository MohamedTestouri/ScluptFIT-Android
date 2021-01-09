package com.esprit.scluptfit.views.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.esprit.scluptfit.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

import androidx.fragment.app.Fragment;

public class
SignupFragmentFirst extends Fragment {
    private TextInputLayout firstName;
    private TextInputLayout lastName;
    private TextInputLayout phone;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private DatePicker birthdayDatePicker;
    private Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_signup_first, container, false);
        firstName = rootView.findViewById(R.id.firstName);
        lastName = rootView.findViewById(R.id.lastName);
        phone = rootView.findViewById(R.id.phone);
        radioGroup = rootView.findViewById(R.id.genderRadioGroup);
        birthdayDatePicker = rootView.findViewById(R.id.birthday);
        nextButton = rootView.findViewById(R.id.NextStep);
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateTextInput(firstName) | !validateTextInput(lastName) | !validateTextInput(phone)) {
                    return;
                } else {
                    radioButton = rootView.findViewById(radioGroup.getCheckedRadioButtonId());
                    Log.d("Radio", radioButton.getText().toString());
                    showFragment();
                }
            }
        });

        return rootView;
    }

    public void showFragment() {
        Fragment fragment = new SignupFragmentSecond();
        Bundle data = new Bundle();
        data.putString("fullName", firstName.getEditText().getText().toString() + " " + lastName.getEditText().getText().toString());
        data.putString("phone", phone.getEditText().getText().toString());
        data.putString("gender", radioButton.getText().toString());
        int month = birthdayDatePicker.getMonth() + 1;
        data.putString("birthday",  birthdayDatePicker.getYear()+ "-" + month + "-" +birthdayDatePicker.getDayOfMonth() );
        fragment.setArguments(data);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
    }

    public Boolean validateTextInput(TextInputLayout textInput) {
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