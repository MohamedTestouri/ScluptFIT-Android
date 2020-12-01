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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserService {
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
                Log.d("ID: ",response.body().getIdUser());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
    }

    public void addHealthInformation() throws JSONException {

        JSONObject object = new JSONObject();
        JSONObject innerObject = new JSONObject();
        innerObject.put("weight", 500);
        innerObject.put("height", 58);
        object.put("healthInformation", innerObject);

        Call<User> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).addHealthInformation("5fb31113ae4613314cbcd860", object);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Log.d("Health", "NOT OKAY");
                } else {
                    Log.d("Health", "OKAY");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
