package com.esprit.scluptfit.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.esprit.scluptfit.R;
import com.google.android.material.textfield.TextInputLayout;
import android.app.DatePickerDialog;
import android.app.Dialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSecon#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSecon extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentSecon() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSecon.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSecon newInstance(String param1, String param2) {
        FragmentSecon fragment = new FragmentSecon();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_secon, container, false);
        final Calendar myCalendar = Calendar.getInstance();

        Button next = (Button) rootView.findViewById(R.id.btn_return);
        Button sign = (Button) rootView.findViewById(R.id.signReg);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Fragment frag;
                frag =new FragmentPrem();
                FragmentManager fm=getActivity().getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.fragment,frag);
                ft.commit();
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!validatheight() | !validatweight()) {
                    return;
                } else {
                    Intent intent = new Intent(getContext(), SignUpValideActivity.class);
                    startActivity(intent);
                }
            }});


        return  rootView;    }

    private  Boolean validatheight(){
        TextInputLayout height=(TextInputLayout) getView().findViewById(R.id.heightReg);
        String val=height.getEditText().getText().toString();

        if (val.isEmpty()){
            height.setError("Field cannot be empty");
            return false;
        }else {
            height.setError(null);
            height.setErrorEnabled(false);
            return  true;


        }
    }
    private  Boolean validatweight(){
        TextInputLayout weight=(TextInputLayout) getView().findViewById(R.id.weightReg);
        String val=weight.getEditText().getText().toString();

        if (val.isEmpty()){
            weight.setError("Field cannot be empty");
            return false;
        }else {
            weight.setError(null);
            weight.setErrorEnabled(false);
            return  true;


        }
    }
}