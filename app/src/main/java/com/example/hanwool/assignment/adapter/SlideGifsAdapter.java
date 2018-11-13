package com.example.hanwool.assignment.adapter;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hanwool.assignment.R;
import com.example.hanwool.assignment.modal.Lastest;

import java.util.ArrayList;

public class SlideGifsAdapter extends PagerAdapter {

        private static final String TAG = "ImageViewPage";
        Context mContext;
        LayoutInflater mLayoutInflater;
        ArrayList<Lastest> mResources;

        public SlideGifsAdapter(Context context, ArrayList<Lastest> resources) {
            mContext = context;
            mResources = resources;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.d(TAG,
                    "instantiateItem() called with: " + "container = [" + container + "], position = [" + position + "]");

            View itemView = mLayoutInflater.inflate(R.layout.custom_viewpager, container, false);

         //   Log.d(TAG, "load in gallery:" + mResources[position] + "#end");
             ImageView ivPhoto = (ImageView) itemView.findViewById(R.id.iv_photo);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_logo);
            requestOptions.error(R.drawable.imgerror);
            if (!mResources.get(position).equals("")){
                Glide.with(mContext)
                        .setDefaultRequestOptions(requestOptions)
                        .load(mResources.get(position).getImgLastest().trim()).into(ivPhoto);
            }

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d(TAG, "destroyItem() called with: " + "container = [" + container + "], position = [" + position
                    + "], object = [" + object + "]");
            container.removeView((LinearLayout) object);
        }
    }
