package com.esprit.scluptfit.utils;

import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.entities.User;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetDataService {
    /* **** EXERCICES SERVICES **** */
    @GET("/exercices")
    Call<ArrayList<Exercice>> getAllExercices();

    @GET("/exercices/{id}")
    Call<ArrayList<Exercice>> getExercicesById(@Path("id") String _id);

    @GET("/exercices/find/{category}")
    Call<ArrayList<Exercice>> getExercicesByCategory(@Path("category") String category);

    /* **** USERS SERVICES **** */
    @POST("/users/login")
    Call<LoginResponse> Login(@Body User user);

    @POST("/users/signup")
    Call<User> Signup(@Body User user);

    @GET("/users/find/{id}")
    Call<ArrayList<User>> getUserByIdUser(@Path("id") String idUser);

    @POST("/users/hi/{id}")
    Call<User> addHealthInformation(@Path("id") String idUser, @Body JSONObject healthInformation);

    /* **** POSTS SERVICE **** */
    @GET("/posts")
    Call<ArrayList<Post>> getAllPosts();

    @GET("/posts/{id}")
    Call<ArrayList<Post>> getPostsById(@Path("id") String _id);

    @GET("/posts/find/{idUser}")
    Call<ArrayList<Post>> getPostsByIdUser(@Path("idUser") String idUser);

    @POST("/posts/comments/{idPost}")
    Call<ResponseBody> addComment(@Path("idPost") String idPost, @Body JSONObject comment);
  /*  @PATCH("/posts/comments/update/{idPost}&{idComment}")
    Call<Post.Comment> updateComment(@Path("idPost") String idPost, @Path("idComment") String idComment);*/

    @DELETE("/posts/{id}")
    Call<Void> deletePost(@Path("id") String _id);

    @POST("/posts")
    Call<Post> postPost (@Body Post post);

    @PATCH("/posts/text/{id}")
    Call<Post> updatePostText(@Path("id") String idPost, @Body Post post);

    @PATCH("/posts/likes/{id}")
    Call<Post> updatePostLikes(@Path("id") String idPost, @Body Post post);


}
