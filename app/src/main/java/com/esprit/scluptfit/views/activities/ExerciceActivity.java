package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        startButton = findViewById(R.id.startButton);
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Exercice>> call = service.getAllExercices();
        call.enqueue(new Callback<ArrayList<Exercice>>() {
            @Override
            public void onResponse(Call<ArrayList<Exercice>> call, Response<ArrayList<Exercice>> response) {
                generateDataList(response.body());
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