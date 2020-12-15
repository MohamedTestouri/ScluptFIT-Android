package com.esprit.scluptfit.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.esprit.scluptfit.views.activities.RunningActivity;
import com.esprit.scluptfit.views.adapters.RunningAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RunningFragment extends Fragment {
    private Button runButton;
    private ProgressBar progressBar;
    private RecyclerView runsRecyclerView;
    private RunningAdapter runningAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_running, container, false);
        runButton = rootView.findViewById(R.id.run);
        runsRecyclerView = rootView.findViewById(R.id.runsRecyclerView);
        runButton.setOnClickListener(l -> {
            startActivity(new Intent(getActivity(), RunningActivity.class));
        });
        progressBar = rootView.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .getUserById("5fcaa72555106324acdfdfcf")
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        runningAdapter = new RunningAdapter(getContext(), response.body().getRun());
                        runsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        runsRecyclerView.setAdapter(runningAdapter);
                        Toast.makeText(getContext(), "JAWEK BEHI AALEKHER", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                        Toast.makeText(getContext(), "MNAYEKA AALIK AALEKHER", Toast.LENGTH_LONG).show();
                    }
                });
        return rootView;
    }
}