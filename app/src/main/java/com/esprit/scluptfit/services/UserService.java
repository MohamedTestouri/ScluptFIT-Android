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
import com.esprit.scluptfit.views.activities.SignUpValideActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserService {
    public void Login(Context context, String email, String password){
        Call<LoginResponse> call = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class).login(new User(email, password));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.body() != null) {
                    Log.d("RES_BODY", "NOT NULL");
                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    context.startActivity(new Intent(context, HomeActivity.class));
                }else {
                    Log.d("RES_BODY", "NULL");
                    Toast.makeText(context, "Account doesn't exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
    public void Signup(Context context){
        context.startActivity(new Intent(context, SignUpValideActivity.class));
    }
}
