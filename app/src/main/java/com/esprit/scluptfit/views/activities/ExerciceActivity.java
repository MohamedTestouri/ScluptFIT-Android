package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.esprit.scluptfit.views.adapters.ExerciceAdapter;

import java.util.ArrayList;

public class ExerciceActivity extends AppCompatActivity {
    private RecyclerView exerciceRecyclerView;
    private Button startButton;
    private ExerciceAdapter exerciceAdapter;
    private ProgressBar exerciceProgressBar;
    private TextView categoryNameTextView;
    private ImageButton backImageButton;
    private ConstraintLayout topLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        categoryNameTextView = findViewById(R.id.categoryNameTextView);
        backImageButton = findViewById(R.id.backImageButton);
        startButton = findViewById(R.id.startButton);
        exerciceProgressBar = findViewById(R.id.exerciceProgressBar);
        topLayout  = findViewById(R.id.topLayout);
        categoryNameTextView.setText(getIntent().getExtras().getString("Category"));
        exerciceProgressBar.setVisibility(View.VISIBLE);
        getExercices();
        startButton.setOnClickListener(l-> {
            Intent intent = new Intent(ExerciceActivity.this, ArActivity.class);
          //  intent.putExtra()
            startActivity(intent);
        });
        backImageButton.setOnClickListener(l->{finish();});
    }

    private void getExercices() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Exercice>> call = service.getExercicesByCategory(getIntent().getExtras().getString("Category"));
        call.enqueue(new Callback<ArrayList<Exercice>>() {
            @Override
            public void onResponse(Call<ArrayList<Exercice>> call, Response<ArrayList<Exercice>> response) {
                generateDataList(response.body());
                exerciceProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<Exercice>> call, Throwable t) {
                Toast.makeText(ExerciceActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(ArrayList<Exercice> exerciceArrayList) {
        exerciceRecyclerView = findViewById(R.id.exerciceRecyclerView);
        exerciceAdapter = new ExerciceAdapter(this, exerciceArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ExerciceActivity.this);
        exerciceRecyclerView.setLayoutManager(layoutManager);
        exerciceRecyclerView.setAdapter(exerciceAdapter);
    }
}