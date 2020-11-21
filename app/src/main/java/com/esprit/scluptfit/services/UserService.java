package com.esprit.scluptfit.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.entities.User;
import com.esprit.scluptfit.utils.Instance;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserService {
    private Context context;
    private ArrayList<User> userArrayList = new ArrayList<>();
    private String api_url = "http://localhost:6666/users";

    public UserService(Context context) {
        this.context = context;
    }
    public ArrayList<User> getUserById(String id) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, api_url+"/find/"+id, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                while (count < response.length()) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        User user = new User(
                                //
                        );
                        userArrayList.add(user);
                        count++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "ERROR: " + error, Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });
        Instance.getInstance(context).addToRequestQueue(jsonArrayRequest);
        return userArrayList;
    }
}
