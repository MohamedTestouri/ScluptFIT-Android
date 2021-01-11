package com.esprit.scluptfit.views.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.services.UserService;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
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
import com.google.gson.Gson;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.esprit.scluptfit.services.UserService.sharedPrefFile;

public class HomeFragment extends Fragment implements SensorEventListener {

    private TextView stepsTextView;
    private TextView caloriesTextView;
    private TextView runsTextView;
    private SensorManager sensorManager;
    private PieChart stepsPieChart;
    float steps;
    private ArrayList<PieEntry> pieEntryArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        stepsTextView = rootView.findViewById(R.id.stepsTextView);
        stepsPieChart = rootView.findViewById(R.id.stepsPieChart);
        caloriesTextView = rootView.findViewById(R.id.calorieTextView);
        runsTextView = rootView.findViewById(R.id.runsTextView);
        sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        System.out.println("SharedPrefs"+getContext().getSharedPreferences(sharedPrefFile, MODE_PRIVATE).getString("currentUser", ""));
        getInformations();
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



        pieEntryArrayList.add(new PieEntry(0, ""));
        pieEntryArrayList.add(new PieEntry(15000f , ""));
        stepsPieChart.animateY(3000, Easing.EaseInOutCubic);
        PieDataSet pieDataSet = new PieDataSet(pieEntryArrayList, "");
        pieDataSet.setSelectionShift(5f);
        pieDataSet.setColors(getResources().getColor(R.color.primaryBackground), getResources().getColor(R.color.primaryColor));
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
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        stepsTextView.setText(""+event.values[0]);
        System.out.println("Value:"+event.values[0]);
        steps = Float.valueOf(stepsTextView.getText().toString());
        pieEntryArrayList.remove(1);
        pieEntryArrayList.remove(0);
        pieEntryArrayList.add(new PieEntry(15000f-steps, ""));
        pieEntryArrayList.add(new PieEntry(steps, ""));



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @SuppressLint("SetTextI18n")
    public void getInformations() {
        UserService userService = new UserService();
        User currentUser = userService.getUserById(getContext());
        caloriesTextView.setText("aa");
        runsTextView.setText("bb");
    }

}