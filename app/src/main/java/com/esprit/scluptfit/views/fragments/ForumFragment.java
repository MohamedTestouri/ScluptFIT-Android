package com.esprit.scluptfit.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.esprit.scluptfit.views.adapters.ForumAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForumFragment extends Fragment implements ForumAdapter.OnPostListener {
    private RecyclerView postRecyclerView;
    private ForumAdapter forumAdapter;
    private ArrayList<Post> postArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_forum, container, false);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Post>> call = service.getAllPosts();
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                postRecyclerView = rootView.findViewById(R.id.postRecyclerView);
                forumAdapter = new ForumAdapter(getContext(), response.body(), ForumFragment.this::onLikePost);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                postRecyclerView.setLayoutManager(layoutManager);
                postRecyclerView.setAdapter(forumAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }


        });
        return rootView;
    }


    @Override
    public void onLikePost(int position) {
        System.out.println("CLicKeD"+position        );
    }
}
