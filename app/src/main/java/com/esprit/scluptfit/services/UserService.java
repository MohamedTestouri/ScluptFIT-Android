package com.esprit.scluptfit.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.utils.GetDataService;
import com.esprit.scluptfit.utils.LoginResponse;
import com.esprit.scluptfit.utils.RetrofitClientInstance;
import com.esprit.scluptfit.views.activities.HomeActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.Map;

import androidx.fragment.app.FragmentActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class UserService {
    public static final String sharedPrefFile = "com.esprit.scluptfit";
    public SharedPreferences sharedPreferences;

    public void getAllUsers( ) {
        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .getAllUsers()
                .enqueue(new Callback<ArrayList<User>>() {
                    @Override
                    public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {

                    }

                    @Override
                    public void onFailure(Call<ArrayList<User>> call, Throwable t) {

                    }
                });
    }

    public User getUserById(Context context) {
        sharedPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
         User currentUser = new Gson().fromJson(sharedPreferences.getString("currentUser", ""), User.class);

        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .getUserById(currentUser.getIdUser())
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
        System.out.println(currentUser.getIdUser()+"");
        return currentUser;
    }

    public void Login(Context context, User user) {
        sharedPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .Login(user)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.body() != null) {
                            SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
                            User currentUser = response.body();
                            Gson gson = new Gson();
                            String json = gson.toJson(currentUser);
                            System.out.println(json.toString());
                            preferencesEditor.putString("currentUser", json);
                            preferencesEditor.apply();
                            context.startActivity(new Intent(context, HomeActivity.class));
                        } else {
                            Log.d("RES_BODY", "NULL");
                            Toast.makeText(context, "Account doesn't exist", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
    }

    public void Signup(Context context, User user) {
        sharedPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .Signup(user)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
                        User currentUser = response.body();
                        Gson gson = new Gson();
                        String json = gson.toJson(currentUser);
                        System.out.println(json.toString());
                        preferencesEditor.putString("currentUser", json);
                        preferencesEditor.apply();

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                    }
                });
    }

    public void logout(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();
    }

    public void deleteUser(Context context) {
        sharedPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        User currentUser = new Gson().fromJson(sharedPreferences.getString("currentUser", ""), User.class);
        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .deleteUser(currentUser.getIdUser())
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                    }
                });
    }

    public void addActivity(Context context) {
        sharedPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        User currentUser = new Gson().fromJson(sharedPreferences.getString("currentUser", ""), User.class);
        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .addActivity(currentUser.getIdUser(),
                        Double.parseDouble("22"),
                        "5fb2fce6a5a5f01e485444fa")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }

    public void addHealthInformation(Context context, User.HealthInformation healthInformation) {
        sharedPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        User currentUser = new Gson().fromJson(sharedPreferences.getString("currentUser", ""), User.class);
        RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class)
                .addHealthInformation(currentUser.getIdUser(),
                        healthInformation.getCalories(),
                        Double.valueOf(healthInformation.getSteps()),
                        healthInformation.getWeight(),
                        healthInformation.getHeight()).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void addRun(Context context, User.Run run) {
        sharedPreferences = context.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        User currentUser = new Gson().fromJson(sharedPreferences.getString("currentUser", ""), User.class);
        RetrofitClientInstance.getRetrofitInstance()
                .create(GetDataService.class)
                .addRun(currentUser.getIdUser(), run.getCalories(), run.getDistance(), run.getDuration())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }
}
