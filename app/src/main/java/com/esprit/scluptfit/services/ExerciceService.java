package com.esprit.scluptfit.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.esprit.scluptfit.entities.Exercice;
import com.esprit.scluptfit.utils.Instance;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ExerciceService {
    private Context context;
    private ArrayList<Exercice> exerciceArrayList = new ArrayList<>();
    private String api_url = "http://localhost:6666/exercices";

    public ExerciceService(Context context) {
        this.context = context;
    }

    public ArrayList<Exercice> getAllExercices() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, api_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                while (count < response.length()) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        Exercice exercice = new Exercice(jsonObject.getString("_id"), jsonObject.getString("name"), jsonObject.getString("description"),
                                jsonObject.getString("category"), jsonObject.getString("model"), jsonObject.getString("audio"), jsonObject.getString("image"));
                        exerciceArrayList.add(exercice);
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
        return exerciceArrayList;
    }

    public ArrayList<Exercice> getExercicesById(String id) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, api_url+"/"+id, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                while (count < response.length()) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        Exercice exercice = new Exercice(jsonObject.getString("_id"), jsonObject.getString("name"), jsonObject.getString("description"),
                                jsonObject.getString("category"), jsonObject.getString("model"), jsonObject.getString("audio"), jsonObject.getString("image"));
                        exerciceArrayList.add(exercice);
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
        return exerciceArrayList;
    }

    public ArrayList<Exercice> getExercicesByCategory(String category) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, api_url+"/find/"+category, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                while (count < response.length()) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        Exercice exercice = new Exercice(jsonObject.getString("_id"), jsonObject.getString("name"), jsonObject.getString("description"),
                                jsonObject.getString("category"), jsonObject.getString("model"), jsonObject.getString("audio"), jsonObject.getString("image"));
                        exerciceArrayList.add(exercice);
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
        return exerciceArrayList;
    }
}
