package com.esprit.scluptfit.views.fragments;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements SensorEventListener {

    private TextView stepsTextView;
    private Float steps = 700f;
    private SensorManager sensorManager;
    private PieChart stepsPieChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        stepsTextView = rootView.findViewById(R.id.stepsTextView);
        stepsPieChart = rootView.findViewById(R.id.stepsPieChart);
        sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);

        // START PIE CHART
        stepsPieChart.setUsePercentValues(false);
        stepsPieChart.setDrawMarkers(true);
        stepsPieChart.getDescription().setEnabled(false);
        stepsPieChart.setExtraOffsets(5, 5, 5, 5);
        stepsPieChart.setDragDecelerationFrictionCoef(0.95f);
        stepsPieChart.setDrawHoleEnabled(true);
        stepsPieChart.setHoleRadius(75f);
        stepsPieChart.setHoleColor(getResources().getColor(R.color.transparent));
        stepsPieChart.getLegend().setEnabled(false);
        stepsPieChart.setBackgroundColor(getResources().getColor(R.color.transparent));


        ArrayList<PieEntry> pieEntryArrayList = new ArrayList<>();
        pieEntryArrayList.add(new PieEntry(steps, ""));
        pieEntryArrayList.add(new PieEntry(10000f - steps, ""));
        stepsPieChart.animateY(2000, Easing.EaseInOutCubic);
        PieDataSet pieDataSet = new PieDataSet(pieEntryArrayList, "");
        pieDataSet.setSelectionShift(5f);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        PieData pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(10f);
        stepsPieChart.setData(pieData);


        // END PIE CHART
        LineChart lineChart = rootView.findViewById(R.id.barChart);
        // lineChart.setOnChartGestureListener((OnChartGestureListener) getActivity());
        // lineChart.setOnChartValueSelectedListener((OnChartValueSelectedListener) getActivity());
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);

        //chart1
        getSteps();
        ArrayList<Entry> chart1 = new ArrayList<>();

        chart1.add(new Entry(0, 60));
        chart1.add(new Entry(1, 30));
        chart1.add(new Entry(2, 70));
        chart1.add(new Entry(3, 66));
        chart1.add(new Entry(4, 45));
        chart1.add(new Entry(5, 85));
        chart1.add(new Entry(6, 20));

        LineDataSet set1 = new LineDataSet(chart1, "Steps");
        set1.setFillAlpha(110);
        set1.setColor(R.color.primaryColor);

        //chart1

        ArrayList<Entry> chart2 = new ArrayList<>();

        chart2.add(new Entry(0, 120));
        chart2.add(new Entry(1, 100));
        chart2.add(new Entry(2, 82));
        chart2.add(new Entry(3, 90));
        chart2.add(new Entry(4, 100));
        chart2.add(new Entry(5, 70));
        chart2.add(new Entry(6, 50));

        LineDataSet set2 = new LineDataSet(chart2, "Poid");
        set2.setFillAlpha(100);


        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);


        LineData lineData = new LineData(dataSets);
        lineChart.setData(lineData);





        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        }
//        steps = Float.valueOf(stepsTextView.getText().toString());
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        stepsTextView.setText(""+event.values[0]);
        steps = event.values[0];


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void getSteps() {
//        return stepsArrayList;
    }
}