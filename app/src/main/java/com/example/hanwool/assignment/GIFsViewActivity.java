package com.example.hanwool.assignment;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hanwool.assignment.adapter.SlideGifsAdapter;
import com.example.hanwool.assignment.modal.Lastest;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class GIFsViewActivity extends AppCompatActivity {
ArrayList<Lastest> arrGif;
int index;
ViewPager imgGif;
ArrayList<Lastest> urls;
    String a;
//    Lastest lastest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifs_webview);
        imgGif = findViewById(R.id.vp_photogallery);
urls= new ArrayList<>();
// Lastest lastest= (Lastest) getIntent().getSerializableExtra("url");
   arrGif = (ArrayList<Lastest>) getIntent().getSerializableExtra("url");
//        index = i.getIntExtra("index", 100);
//       for (int i = 0 ; i < arrGif.size(); i++) {
//           a = arrGif.get(i).getImgLastest();
//
//       }

        Toast.makeText(getApplicationContext(), "" + arrGif.size(), Toast.LENGTH_SHORT).show();
//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.placeholder(R.drawable.ic_logo);
//        requestOptions.error(R.drawable.imgerror);
//        for (int i = 0; i <arrGif.size(); i++){
//            Glide.with(this)
//                    .setDefaultRequestOptions(requestOptions)
//                    .load(arrGif.get(i).getImgLastest()).into(imgGif);
//        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_photogallery);

        if (viewPager != null) {

                viewPager.setAdapter(new SlideGifsAdapter(GIFsViewActivity.this, arrGif));



        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
