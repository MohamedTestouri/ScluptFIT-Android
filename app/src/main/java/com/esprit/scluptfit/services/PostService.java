package com.esprit.scluptfit.services;

import android.content.Context;

import com.esprit.scluptfit.entities.Post;

import java.util.ArrayList;

public class PostService {

    private Context context;
    private ArrayList<Post> exerciceArrayList = new ArrayList<>();
    private String api_url = "http://localhost:6666/exercices";

    public PostService(Context context) {
        this.context = context;
    }




    }
