package com.esprit.scluptfit.views.fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.icu.number.Precision;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.services.UserService;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.DecimalFormat;
import java.time.Duration;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

public class RunFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap map;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;
    private LocationManager locationManager;
    private LatLng latLng;
    private Boolean clicked = false;
    private Button startButton;
    private Chronometer chronometer;
    private boolean running;
    private TextView distanceTextView;

    UserService userService = new UserService();
    DecimalFormat format = new DecimalFormat("0.000");

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_run, container, false);
        distanceTextView = rootView.findViewById(R.id.distanceTextView);
        startButton = rootView.findViewById(R.id.startButton);

//Chrono
        chronometer = rootView.findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %m");
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                System.out.println(time);
                int h = (int) (time / 3600000);
                int m = (int) (time - h * 3600000) / 60000;
                int s = (int) (time - h * 3600000 - m * 60000) / 1000;
                String hh = h < 10 ? "0" + h : h + "";
                String mm = m < 10 ? "0" + m : m + "";
                String ss = s < 10 ? "0" + s : s + "";
                chronometer.setText(hh + ":" + mm + ":" + ss);
                /*if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                }*/
            }
        });
        // MAP !!
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);
        client = LocationServices.getFusedLocationProviderClient(getActivity());
        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            client.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        mapFragment.getMapAsync(new OnMapReadyCallback() {
                            @Override
                            public void onMapReady(GoogleMap googleMap) {
                                latLng = new LatLng(location.getLatitude(), location.getLongitude());
                                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    return;
                                }
                                googleMap.setMyLocationEnabled(true);
                            }
                        });
                    }
                }
            });
            startButton.setOnClickListener(l -> {
                if (!clicked) {
                    startChronometer();
                    clicked = true;
                    startButton.setText("Stop Running");
                } else {
                    stopChronometer();
                    clicked = false;
                    startButton.setText("Start Running");
                    double latitude = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude();
                    double longitude = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude();
                    LatLng endPosition = new LatLng(latitude, longitude);
                    PolylineOptions lineOptions = new PolylineOptions()
                            .add(latLng)
                            .add(endPosition)
                            .width(5)
                            .color(Color.parseColor("#FFE30F39"));
                    map.addPolyline(lineOptions);
                    map.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("End Position"));
                    stopChronometer();
                    double time = (double) (SystemClock.elapsedRealtime() - chronometer.getBase()) / 60000;
                    double duration = Double.valueOf(format.format(time));
                    double distance = Double.valueOf(format.format(CalculationByDistance(latLng, endPosition)));
                    userService.addRun( getContext(), new User.Run(10.0, distance, duration));
                    distanceTextView.setText(distance + " KM");
                    getActivity().finish();

                }
            });
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        mapFragment.getMapAsync(this::onMapReady);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }

    public void startChronometer() {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            map.addMarker(new MarkerOptions().position(latLng).title("Start Position!"));
            running = true;
        }
    }

    public void stopChronometer() {
        if (running) {
            chronometer.stop();
            running = false;
        }
    }

    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        return valueResult;
    }


}