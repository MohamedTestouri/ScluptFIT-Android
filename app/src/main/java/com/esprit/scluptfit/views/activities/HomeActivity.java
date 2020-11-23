package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.widget.Button;
import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.views.fragments.ExerciceFragement;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
private Button button;
private ArrayList<Exercice> exerciceArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button = findViewById(R.id.buttonA);
        button.setOnClickListener(l->{
           showFragment(new ExerciceFragement());
        });
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}