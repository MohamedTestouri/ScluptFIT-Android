package com.esprit.scluptfit.views.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.esprit.scluptfit.views.adapters.ForumAdapter;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment implements ForumAdapter.OnPostListener {

    private SharedPreferences sharedPreferences;

    private RecyclerView myPostsRecyclerView;
    private ForumAdapter forumAdapter;
    private ArrayList<Post> postArrayList = new ArrayList<>();

    private TextView stepsTextView;
    private TextView caloriesTextView;
    private TextView weightTextView;
    private TextView fullNameTextView;

    private static final String PREFS = "Settings";
    private String idUser = "5fcaa6fe55106324acdfdfce";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        fullNameTextView = rootView.findViewById(R.id.fullNameTextView);
        stepsTextView = rootView.findViewById(R.id.stepsTextView);
        caloriesTextView = rootView.findViewById(R.id.caloriesTextView);
        weightTextView = rootView.findViewById(R.id.weightTextView);
        myPostsRecyclerView = rootView.findViewById(R.id.myPostsRecyclerView);

        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .getUserById(idUser)
                .enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    int lastHealthInformation = response.body().getHealthInformation().size() - 1;
                    User.HealthInformation healthInformation = response.body().getHealthInformation().get(lastHealthInformation);
                    fullNameTextView.setText(response.body().getFullName());
                    stepsTextView.setText("" + healthInformation.getSteps());
                    caloriesTextView.setText("" + healthInformation.getCalories());
                    weightTextView.setText("" + healthInformation.getWeight());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .getPostsByIdUser("5fb3109cbb971938a473450e")
                .enqueue(new Callback<ArrayList<Post>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                        forumAdapter = new ForumAdapter(getContext(), response.body(), ProfileFragment.this::onLikePost);
                        myPostsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        myPostsRecyclerView.setHasFixedSize(false); // no fix size
                        myPostsRecyclerView.setAdapter(forumAdapter);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                    }
                });
        return rootView;

    }

    @Override
    public void onLikePost(int position) {

    }
}