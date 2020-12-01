package com.esprit.scluptfit.views.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.views.fragments.HomeFragment;
import com.esprit.scluptfit.views.fragments.RunFragment;

public class RunningActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new RunFragment()).commit();

    }
}