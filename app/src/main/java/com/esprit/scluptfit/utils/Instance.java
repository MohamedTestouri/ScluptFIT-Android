package com.esprit.scluptfit.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Instance {
    private static Instance myInstance;
    private RequestQueue requestQueue;
    private static Context context;

    public Instance(Context context ) {
        this.context = context;
        this.requestQueue = requestQueue;
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public static synchronized Instance getInstance(Context context){
        if(myInstance==null){
            myInstance = new Instance(context);
        }
        return myInstance;
    }
    public void addToRequestQueue(Request request){
        requestQueue.add(request);
    }
}
