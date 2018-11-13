package com.example.hanwool.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.hanwool.assignment.adapter.CategoriesAdapter;
import com.example.hanwool.assignment.adapter.LastestAdapter;
import com.example.hanwool.assignment.modal.Lastest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImageInCatActivity extends AppCompatActivity {
RecyclerView lvImgInCat;
ArrayList<Lastest> arrImgInCat;
LastestAdapter imgInCatAdapter;
    int catID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_in_cat);
        Anhxa();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    private void Anhxa() {
        Intent i = getIntent();
       catID = i.getIntExtra("cid", 0);
        arrImgInCat= new ArrayList<>();

Toast.makeText(getApplicationContext(),"" + catID, Toast.LENGTH_SHORT).show();
        lvImgInCat = findViewById(R.id.lvImgInCat);
        imgInCatAdapter = new LastestAdapter(getApplicationContext(), arrImgInCat);
        lvImgInCat.setHasFixedSize(true);
        lvImgInCat.setLayoutManager
                (new GridLayoutManager(this,2));
        lvImgInCat.setAdapter(imgInCatAdapter);
        getImgInCat();
    }

    private void getImgInCat() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(JsonRequest.Method.GET,
                "http://www.tapetee.com//api.php?cat_id="+String.valueOf(catID), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response != null){

                    String image = "";

                    int views = 0;
                    try {
                        JSONArray jsonArray = response.getJSONArray("HD_WALLPAPER");
                        for (int i =0; i<jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            image = jsonObject.getString("wallpaper_image");

                            views = jsonObject.getInt("total_views");

                            arrImgInCat.add(new Lastest(image,views));
                            imgInCatAdapter.notifyDataSetChanged();
                            // Toast.makeText(getApplicationContext(), "fgdg " +String.valueOf(arrLastest.size()), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}
