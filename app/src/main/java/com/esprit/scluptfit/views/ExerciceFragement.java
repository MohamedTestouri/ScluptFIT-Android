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
    private CardView chestCardView;
    private CardView armCardView;
    private CardView legsCardView;
    private CardView shoulderCardView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_exercices, container, false);
        absCardView = rootView.findViewById(R.id.absCardView);
        chestCardView = rootView.findViewById(R.id.chestCardView);
        armCardView = rootView.findViewById(R.id.armCardView);
        legsCardView = rootView.findViewById(R.id.legsCardView);
        shoulderCardView = rootView.findViewById(R.id.shoulderCardView);
        absCardView.setOnClickListener(l -> {
            Intent intent = new Intent(getContext(), ExerciceActivity.class);
            intent.putExtra("Category", "abs");
            startActivity(intent);
        });
        chestCardView.setOnClickListener(l -> {
            Intent intent = new Intent(getContext(), ExerciceActivity.class);
            intent.putExtra("Category", "chest");
            startActivity(intent);
        });
        armCardView.setOnClickListener(l -> {
            Intent intent = new Intent(getContext(), ExerciceActivity.class);
            intent.putExtra("Category", "abs");
            startActivity(intent);
        });
        legsCardView.setOnClickListener(l -> {
            Intent intent = new Intent(getContext(), ExerciceActivity.class);
            intent.putExtra("Category", "abs");
            startActivity(intent);
        });
        shoulderCardView.setOnClickListener(l -> {
            Intent intent = new Intent(getContext(), ExerciceActivity.class);
            intent.putExtra("Category", "abs");
            startActivity(intent);
        });

        return rootView;
    }
}
