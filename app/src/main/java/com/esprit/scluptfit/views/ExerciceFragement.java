package com.esprit.scluptfit.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esprit.scluptfit.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ExerciceFragement extends Fragment {
    private CardView absCardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_exercices, container, false);
        absCardView = rootView.findViewById(R.id.absCardView);
        absCardView.setOnClickListener(l -> {
            Intent intent = new Intent(getContext(), ExerciceActivity.class);
            intent.putExtra("Category", "abs");
            startActivity(intent);
        });

        return rootView;
    }
}
