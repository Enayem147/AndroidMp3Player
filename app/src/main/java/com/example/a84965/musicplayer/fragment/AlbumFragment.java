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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a84965.musicplayer.R;
import com.example.a84965.musicplayer.adapter.AlbumAdapter;
import com.example.a84965.musicplayer.model.Album;
import com.example.a84965.musicplayer.service.APIService;
import com.example.a84965.musicplayer.service.DataService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumFragment extends Fragment {

    View view;
    ArrayList<Album> listAlbum;
    RecyclerView recyclerViewAlbum;
    TextView txtXemThem;
    AlbumAdapter albumAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album,container,false);
        initControls();
        getData();
        return view;
    }

    private void initControls() {
        recyclerViewAlbum = view.findViewById(R.id.recyclerViewAlbum);
        txtXemThem = view.findViewById(R.id.txtViewMoreAlbum);
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<Album>> callBack = dataService.getAlbum();
        callBack.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                listAlbum = (ArrayList<Album>) response.body();
                albumAdapter = new AlbumAdapter(getActivity(),listAlbum);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewAlbum.setLayoutManager(linearLayoutManager);
                recyclerViewAlbum.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
