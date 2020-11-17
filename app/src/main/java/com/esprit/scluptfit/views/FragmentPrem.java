package com.esprit.scluptfit.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.esprit.scluptfit.R;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPrem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPrem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentPrem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPrem.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPrem newInstance(String param1, String param2) {
        FragmentPrem fragment = new FragmentPrem();
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
       View rootView = inflater.inflate(R.layout.fragment_prem, container, false);
        Button next = (Button) rootView.findViewById(R.id.NextStep);
        next.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v)
            {
                if (!validatFirstname() | !validatLastname()){
                    return;
                } else {

                Fragment frag;
                frag =new FragmentSecon();
                FragmentManager fm=getActivity().getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.fragment,frag);
                ft.commit();}
            }
        });

        return  rootView;
    }


    private  Boolean validatFirstname(){
        TextInputLayout firstname=(TextInputLayout) getView().findViewById(R.id.Firstname);
        String val=firstname.getEditText().getText().toString();

        if (val.isEmpty()){
            firstname.setError("Field cannot be empty");
            return false;
        }else {
            firstname.setError(null);
            firstname.setErrorEnabled(false);
            return  true;


}
    }
    private  Boolean validatLastname(){
        TextInputLayout lastname=(TextInputLayout) getView().findViewById(R.id.Lastname);
        String val=lastname.getEditText().getText().toString();

        if (val.isEmpty()){
            lastname.setError("Field cannot be empty");
            return false;
        }else {
            lastname.setError(null);
            lastname.setErrorEnabled(false);
            return  true;


        }
    }
}