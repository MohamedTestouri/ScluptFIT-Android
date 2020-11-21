package com.esprit.scluptfit.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.services.ExerciceService;

import java.util.ArrayList;

public class ExerciceActivity extends AppCompatActivity {
    private RecyclerView exerciceRecyclerView;
    private Button startButton;
    private ExerciceAdapter exerciceAdapter;
    private ExerciceService exerciceService ;
    private ArrayList<Exercice> exerciceArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        startButton = findViewById(R.id.startButton);
        exerciceRecyclerView = findViewById(R.id.exerciceRecyclerView);
        exerciceRecyclerView.setHasFixedSize(false); // no fix size
        exerciceRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        exerciceService  = new ExerciceService(ExerciceActivity.this);
        exerciceArrayList = exerciceService.getExercicesByCategory(getIntent().getExtras().getString("Category"));
        exerciceAdapter = new ExerciceAdapter(exerciceArrayList);
        exerciceRecyclerView.setAdapter(exerciceAdapter);
    }
}