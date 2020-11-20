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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciceFragement extends Fragment {
    private CardView absCardView;
    private RecyclerView exerciceRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_exercices, container, false);
        absCardView = rootView.findViewById(R.id.absCardView);
        absCardView.setOnClickListener(l->{
            startActivity(new Intent(getContext(), ExerciceActivity.class));
        });
        exerciceRecyclerView = rootView.findViewById(R.id.exerciceRecyclerView);
        exerciceRecyclerView.setHasFixedSize(false); // no fix size
        exerciceRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return rootView;
    }
}
