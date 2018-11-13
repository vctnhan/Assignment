package com.example.hanwool.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.hanwool.assignment.adapter.LastestAdapter;
import com.example.hanwool.assignment.modal.Categories;
import com.example.hanwool.assignment.modal.Lastest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LastestActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<Lastest> arrLastest;
    RecyclerView lvLastest;
    LastestAdapter lastestAdapter;
    public static ArrayList<Lastest> arrFavor;
    public static ArrayList<Lastest> arrGifFavor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Anhxa();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void Anhxa() {
        arrLastest = new ArrayList<>();
        if (arrFavor == null) {
            arrFavor = new ArrayList<>();
        }
        if (arrGifFavor == null) {
            arrGifFavor = new ArrayList<>();
        }

        lvLastest = findViewById(R.id.lvLastest);
        lastestAdapter = new LastestAdapter(getApplicationContext(), arrLastest);
        lvLastest.setHasFixedSize(true);
        lvLastest.setLayoutManager
                (new GridLayoutManager(this, 2));
        lvLastest.setAdapter(lastestAdapter);
        getLastest();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lastest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Latest
        } else if (id == R.id.nav_gallery) {
//Cat
            Intent i = new Intent(getApplicationContext(), CategoriesActivity.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_slideshow) {
//Favor

            Intent i = new Intent(getApplicationContext(), FavouriteActivity.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_manage) {
//GIFs
            Intent i = new Intent(getApplicationContext(), GIFsActivity.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getLastest() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(JsonRequest.Method.GET,
                "http://www.tapetee.com//api.php?latest", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response != null) {

                    String image = "";

                    int views = 0;
                    try {
                        JSONArray jsonArray = response.getJSONArray("HD_WALLPAPER");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            image = jsonObject.getString("wallpaper_image");

                            views = jsonObject.getInt("total_views");

                            arrLastest.add(new Lastest(image, views));
                            lastestAdapter.notifyDataSetChanged();
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
