package com.esprit.scluptfit.services;

import android.util.Log;
import android.widget.Toast;

import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.esprit.scluptfit.views.activities.ExerciceActivity;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostService {
    public void getAllPosts() {
        Call<ArrayList<Post>> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).getAllPosts();
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
            }
        });
    }

    public void getPostsById(String idPost) {
        Call<ArrayList<Post>> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).getPostsById(idPost);
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
            }
        });
    }

    public void getPostsByIdUser(String idUser) {
        Call<ArrayList<Post>> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).getPostsByIdUser(idUser);
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
            }
        });
    }

    public void postPost(Post post) {
        Call<Post> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).postPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public void updatePostText(Post post) {
        Call<Post> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).updatePostText("5fccc79c1b1ffb0004db3d7e",post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public void updatePostLikes(Post post) {
        Call<Post> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).updatePostLikes("5fccc79c1b1ffb0004db3d7e",post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}
