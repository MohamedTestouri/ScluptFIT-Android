package com.esprit.scluptfit.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.services.PostService;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.esprit.scluptfit.views.activities.CommentActivity;
import com.esprit.scluptfit.views.activities.HomeActivity;
import com.esprit.scluptfit.views.activities.StartActivity;
import com.esprit.scluptfit.views.adapters.ForumAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForumFragment extends Fragment implements ForumAdapter.OnPostListener {
    private RecyclerView postRecyclerView;
    private ForumAdapter forumAdapter;
    private ArrayList<Post> postArrayList = new ArrayList<>();
    private Button addPostButton;
    private EditText postText;
    private ProgressBar progressBar;
    PostService postService = new PostService();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_forum, container, false);
        addPostButton = rootView.findViewById(R.id.addPostbutton);
        postText = rootView.findViewById(R.id.postTextField);
        progressBar = rootView.findViewById(R.id.progressBar);
        addPostButton.setOnClickListener(l -> {
            addPost(postText.getText().toString());
            postText.setText("");
            getFragmentManager().beginTransaction()
                    .detach(this)
                    .attach(this)
                    .commit();
        });

        progressBar.setVisibility(View.VISIBLE);
        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .getAllPosts()
                .enqueue(new Callback<ArrayList<Post>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                        postRecyclerView = rootView.findViewById(R.id.postRecyclerView);
                        forumAdapter = new ForumAdapter(getContext(), response.body(), ForumFragment.this::onLikePost);

                        postRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        postRecyclerView.setAdapter(forumAdapter);
                        progressBar.setVisibility(View.GONE);
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
        System.out.println("CLicKeD" + position);
    }

    public void addPost(String text) {
        Post post = new Post(text, "5fcaa6fe55106324acdfdfce");
        postService.addPost(post);

    }
}