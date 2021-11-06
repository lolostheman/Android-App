package com.example.cmscapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.example.cmscapp.ui.home.HomeFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//@GlideModule
//final class MyAppGlideModule extends AppGlideModule {
//    @Override
//    public void applyOptions(Context context, GlideBuilder builder) {
//        // Glide default Bitmap Format is set to RGB_565 since it
//        // consumed just 50% memory footprint compared to ARGB_8888.
//        // Increase memory usage for quality with:
//
//        builder.setDefaultRequestOptions(new RequestOptions().format(DecodeFormat.PREFER_ARGB_8888));
//    }
//}
public class MainActivity2 extends AppCompatActivity {

    private String spoonString;
    public static ArrayList<String> spoonList = new ArrayList<String>();
    private String spoonMeal;
    ImageView imageView;
    private String imageUrl;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spoonString = "";
        spoonList.clear();
        spoonMeal = "";
        getData("missedIngredients", "name");



        TextView textView2 = (TextView) findViewById(R.id.textView7);
        textView2.setText(createMissingIngredientsString(HomeFragment.checkedIngredients));

        TextView textView = (TextView) findViewById(R.id.textView5);
        textView.setText(createMissingIngredientsString(spoonList));




    }
    public void getJson(String jsonString, String header, String header2) throws JSONException {
        JSONArray array = new JSONArray(jsonString);
        for (int i = 0; i < array.length(); i++){
            JSONObject object = array.getJSONObject(i);
            spoonString = object.get(header).toString();
            spoonMeal = object.get("title").toString();
            imageUrl = object.get("image").toString();
            JSONArray array2 = new JSONArray(spoonString);
            spoonString = "";
            for (int j = 0; j < array2.length(); j++) {
                JSONObject object2 = array2.getJSONObject(j);
                spoonString = (object2.get(header2).toString());
                spoonList.add(spoonString);
            }
        }
    }

    public void getData(String header1, String header2) {

        // Create a String request using Volley Library

        String food = String.join(",",HomeFragment.checkedIngredients);

        String myUrl = "https://api.spoonacular.com/recipes/findByIngredients?apiKey=6705979aa7a4453a891bed21c551c4d7&ingredients=" + food + "&number=1";
        System.out.println(myUrl);
        StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{

                            getJson(response, header1, header2);
                            TextView textView = (TextView) findViewById(R.id.textView5);
                            textView.setText(createMissingIngredientsString(spoonList));

                            TextView textView3 = (TextView) findViewById(R.id.textView9);
                            textView3.setText(spoonMeal);
                            imageView = findViewById(R.id.imageView);
                            Glide.with(MainActivity2.this).load(imageUrl).into(imageView);
                            System.out.println(imageUrl);

                        } catch (Exception e) {
                            System.out.println("------------------------------------------------------");
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //System.out.println("------------------------------------------------------");
                        Toast.makeText(

                                MainActivity2.this,
                                volleyError.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(myRequest);


    }

    public String createMissingIngredientsString(ArrayList<String> ingredients){
        String finalList = "";
        for(int i = 0; i < ingredients.size(); i++) {
            finalList = finalList.concat(ingredients.get(i));
            finalList = finalList.concat(" ");
        }

        return finalList;

    }
}