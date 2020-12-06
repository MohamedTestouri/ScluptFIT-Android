package com.esprit.scluptfit.services;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.LoginResponse;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.esprit.scluptfit.views.activities.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserService {
    public void getAllUsers() {
        Call<ArrayList<User>> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).getAllUsers();
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {

            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });
    }

    public void getUserById(String idUser) {
        Call<User> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).getUserById(idUser);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void Login(Context context, String email, String password) {
        Call<LoginResponse> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).Login(new User(email, password));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body() != null) {
                    Log.d("RES_BODY", "NOT NULL");
                    Toast.makeText(context, response.body().getIdUser(), Toast.LENGTH_LONG).show();
                    context.startActivity(new Intent(context, HomeActivity.class));
                } else {
                    Log.d("RES_BODY", "NULL");
                    Toast.makeText(context, "Account doesn't exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    public void Signup(User user) {
        Call<User> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).Signup(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("ID: ", response.body().getIdUser());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
    }

    public void deleteUser(String idUser) {
        Call<Void> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).deleteUser(idUser);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void addActivity() {
        Call<ResponseBody> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class)
                .addActivity("5fcaa6fe55106324acdfdfce", Double.parseDouble("22"), "5fb2fce6a5a5f01e485444fa");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void addHealthInformation() {
        Call<ResponseBody> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class)
                .addHealthInformation("5fcaa6fe55106324acdfdfce",
                        Double.parseDouble("22"),
                        Double.parseDouble("22"),
                        Double.parseDouble("22"),
                        Double.parseDouble("22"));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void addRun() {
        Call<ResponseBody> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class)
                .addRun("5fcaa6fe55106324acdfdfce", Double.parseDouble("22"), Double.parseDouble("22"), Double.parseDouble("22"));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
