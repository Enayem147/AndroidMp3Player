package com.example.a84965.musicplayer.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a84965.musicplayer.R;
import com.example.a84965.musicplayer.adapter.BannerAdapter;
import com.example.a84965.musicplayer.model.QuangCao;
import com.example.a84965.musicplayer.service.APIService;
import com.example.a84965.musicplayer.service.DataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerFragment extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;
    Runnable runnable;
    Handler handler;
    int currentItem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner,container,false);
        initControls();
        GetData();
        return view;
    }

    private void initControls() {
        viewPager = view.findViewById(R.id.viewPager);
        circleIndicator = view.findViewById(R.id.indicatorDefault);
        handler = new Handler();
    }

    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<QuangCao>> callBack = dataService.getDataPanner();
        callBack.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                ArrayList<QuangCao> listBanner = (ArrayList<QuangCao>) response.body();
                bannerAdapter = new BannerAdapter(getActivity(),listBanner);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        if(currentItem >= viewPager.getAdapter().getCount()){
                            currentItem = 0;
                        }
                        viewPager.setCurrentItem(currentItem,true);
                        handler.postDelayed(runnable,4500);
                    }
                };
                handler.postDelayed(runnable,4500);
            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {

            }
        });
    }
}
