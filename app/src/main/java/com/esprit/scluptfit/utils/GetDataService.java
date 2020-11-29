package com.esprit.scluptfit.utils;

import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.entities.Post;
import com.esprit.scluptfit.entities.User;

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


    @Headers({"Accept: application/json"})
    @PUT("/users/hi/{id}")
    Call<User> addHealthInformation(@Path("id") String idUser, @Body ArrayList<User.HealthInformation> healthInformation);

    /* **** POSTS SERVICE **** */
    @GET("/posts")
    Call<ArrayList<Post>> getAllPosts();

    @GET("/posts/{id}")
    Call<ArrayList<Post>> getPostsById(@Path("id") String _id);

    @GET("/posts/find/{idUser}")
    Call<ArrayList<Post>> getPostsByIdUser(@Path("idUser") String idUser);
}
