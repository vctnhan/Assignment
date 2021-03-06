package com.example.hanwool.assignment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hanwool.assignment.LastestActivity;
import com.example.hanwool.assignment.R;
import com.example.hanwool.assignment.adapter.GIFsAdapter;
import com.example.hanwool.assignment.adapter.LastestAdapter;
import com.example.hanwool.assignment.modal.Lastest;

import java.util.ArrayList;

public class GifFragment extends Fragment {
    RecyclerView lvWallFavor;
    ArrayList<Lastest> arrWallFavor;
    GIFsAdapter gifFavorAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.wallpaper_fragment, container, false);
       lvWallFavor = view.findViewById(R.id.lvWallFavor);
       arrWallFavor = new ArrayList<>();
        gifFavorAdapter = new GIFsAdapter(getContext(),LastestActivity.arrGifFavor);
        lvWallFavor.setHasFixedSize(true);
        lvWallFavor.setLayoutManager
                (new GridLayoutManager(getContext(),2));
        lvWallFavor.setAdapter(gifFavorAdapter);
        return view;

    }

    public GifFragment() {

    }
}
