package com.example.mvpexample;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class Model implements Contract.Model {
    String [] name;

    @Override
    public void getNextCourse(OnFinishedListener onFinishedListener, Context applicationContext) {
        onFinishedListener.onFinished(getData(applicationContext));
    }

    private String[] getData(Context applicationContext) {
        String Url = "https://reqres.in/api/users?page=2";
        JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray data=  response.getJSONArray("data");
                    name=new String[data.length()];
                    JSONObject detail;

                    for(int i=0;i<data.length();i++){
                        detail = data.getJSONObject(i);

                        name[i]=detail.getString("email");

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(applicationContext);
        queue.add(objectRequest);
        return name;
    }
}
