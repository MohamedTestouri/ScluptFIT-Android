package com.esprit.scluptfit.utils;

import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.entities.HealthInformation;
import com.esprit.scluptfit.entities.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GetDataService {
    /* **** EXERCICES SERVICES **** */
    @GET("/exercices")
    Call<ArrayList<Exercice>> getAllExercices();

    @GET("/exercices/{idUser}")
    Call<ArrayList<Exercice>> getExercicesByIdUser(@Path("idUser") String idUser);

    @GET("/exercices/find/{category}")
    Call<ArrayList<Exercice>> getExercicesByCategory(@Path("category") String category);

    /* **** USERS SERVICES **** */
    @POST("/users/login")
    Call<LoginResponse> Login(@Body User user);
    @POST("/users/signup")
    Call<User> Signup(@Body User user);
    @GET("/users/find/{_id}")
    Call<ArrayList<User>> getUserByIdUser(@Path("_id") String idUser );
    @PUT("/users/hi/{_id}")
    Call<User> addHealthInformation(@Path("_id") String idUser, @Body HealthInformation healthInformation);
}
