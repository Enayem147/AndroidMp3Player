package com.example.a84965.musicplayer.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a84965.musicplayer.R;
import com.example.a84965.musicplayer.adapter.FavoriteSongAdapter;
import com.example.a84965.musicplayer.model.BaiHat;
import com.example.a84965.musicplayer.service.APIService;
import com.example.a84965.musicplayer.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoriteSongFragment extends Fragment {
    ArrayList<BaiHat> listBaiHat;
    View view;
    RecyclerView recyclerViewFavoriteSong;
    FavoriteSongAdapter favoriteSongAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite_song,container,false);
        initControls();
        getData();
        return  view;
    }

    private void initControls() {
        recyclerViewFavoriteSong = view.findViewById(R.id.recyclerViewFavoriteSong);
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callBack = dataService.getBaiHatYeuThich();
        callBack.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                listBaiHat = (ArrayList<BaiHat>) response.body();
                favoriteSongAdapter = new FavoriteSongAdapter(getActivity(),listBaiHat);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewFavoriteSong.setLayoutManager(linearLayoutManager);
                recyclerViewFavoriteSong.setAdapter(favoriteSongAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }
}
