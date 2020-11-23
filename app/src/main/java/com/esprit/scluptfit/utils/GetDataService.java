package com.esprit.scluptfit.utils;

import com.esprit.scluptfit.entities.Exercice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/exercices")
    Call<ArrayList<Exercice>> getAllExercices();
}
