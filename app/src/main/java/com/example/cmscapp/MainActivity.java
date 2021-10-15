package com.example.cmscapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cmscapp.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        volleyGet();

    }
    public void volleyGet(){
        String url = "https://api.spoonacular.com/recipes/findByIngredients?apiKey=d12911cd0079483dacdafa0885b9796e&ingredients=apples,flour,sugar";
        List<String> jsonResponses = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("missedIngredients");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String email = jsonObject.getString("name");

                        jsonResponses.add(email);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
        System.out.println("--------------------------------------------------");
        System.out.println(jsonResponses);
    }

//    String url = "http://exampleserver.com/route";
//
//    RequestQueue ExampleRequestQueue = Volley.newRequestQueue(this);
//    JsonObjectRequest ExampleRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
//        @Override
//        public void onResponse(JSONObject response) {
//            TextView textView = (TextView) findViewById(R.id.textView1);
//            textView.setText(response.toString());
//        }
//
//    }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
//        @Override
//        public void onErrorResponse(VolleyError error) {
//            //This code is executed if there is an error.
//        }
//    });
//ExampleRequestQueue.add(ExampleRequest);


}