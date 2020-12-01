package com.esprit.scluptfit.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esprit.scluptfit.R;


public class ProfileFragment extends Fragment {

    SharedPreferences sp;
    TextView address;
    private static final String PREFS = "Settings";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_profile, container, false);

        address = rootView.findViewById(R.id.addres_id);

        sp = this.getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        address.setText(sp.getString("mail",""));

        return rootView;

    }
}