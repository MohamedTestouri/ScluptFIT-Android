package com.esprit.scluptfit.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esprit.scluptfit.R;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.views.adapters.ForumAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ForumFragement extends Fragment {
    private RecyclerView postRecyclerView;
    private ForumAdapter forumAdapter;
    private ArrayList<Post> postArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_forum, container, false);
        postRecyclerView = rootView.findViewById(R.id.postRecyclerView);
        postRecyclerView.setHasFixedSize(false); // no fix size
        postRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        forumAdapter = new ForumAdapter(getContext(), postArrayList);
        return rootView;
    }
}
