package com.esprit.scluptfit.services;

import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
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

    public void addComment() throws JSONException {
        Post.Comment comment = new Post.Comment("Hello World", "5fcaa6fe55106324acdfdfce");
        JSONObject commentJsonObject = new JSONObject();
        JSONObject jsonObject = new JSONObject();

        commentJsonObject.put("text", "text");
        commentJsonObject.put("idUser", "5fcaa6fe55106324acdfdfce");
        System.out.println("Comment JsonObject: " + commentJsonObject.toString());
        jsonObject.put("comments", commentJsonObject);
        System.out.println("MOTHERFUCKER: " + jsonObject);
        Call<ResponseBody> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class)
                .addComment("5fccc79c1b1ffb0004db3d7e", jsonObject);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String a = "";
                if (response.isSuccessful()) {
                    a = response.toString();
                    System.out.println("GOOD:" + a);
                } else {
                    a = response.toString();
                    System.out.println("Failed: " + a);
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("NOOOOOONE");
            }
        });

        /* Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(comment);
        jsonElement.getAsString();
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        JsonObject mainJsonObject = new JsonObject();
        String text = comment.getText();
        jsonObject.add("text", "text");
        jsonArray.add(jsonObject);
        mainJsonObject.add("Comments", jsonArray);
        System.out.println(""+mainJsonObject.toString());*/

    }

    public void deletePost(String idPost) {
        Call<Void> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).deletePost(idPost);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
}
