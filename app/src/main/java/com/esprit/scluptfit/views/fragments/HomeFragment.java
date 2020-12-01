package com.esprit.scluptfit.views.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements SensorEventListener {

    private TextView stepsTextView;
    private SensorManager sensorManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        stepsTextView = rootView.findViewById(R.id.stepsTextView);
        sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);

        //chart
        BarChart barChart= rootView.findViewById(R.id.barChart);
        ArrayList<BarEntry> charts= new ArrayList<>();

        charts.add(new BarEntry(2014,150));
        charts.add(new BarEntry(2015,90));
        charts.add(new BarEntry(2016,70));
        charts.add(new BarEntry(2017,100));
        charts.add(new BarEntry(2018,70));
        charts.add(new BarEntry(2019,80));
        charts.add(new BarEntry(2020,75));

        BarDataSet barDataSet = new BarDataSet(charts,"charts");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart Example");
        barChart.animateY(2000);





        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        stepsTextView.setText(String.valueOf(event.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}