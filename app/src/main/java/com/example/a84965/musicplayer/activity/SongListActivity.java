package com.example.a84965.musicplayer.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a84965.musicplayer.R;
import com.example.a84965.musicplayer.adapter.SongListAdapter;
import com.example.a84965.musicplayer.model.BaiHat;
import com.example.a84965.musicplayer.model.PlayList;
import com.example.a84965.musicplayer.model.QuangCao;
import com.example.a84965.musicplayer.service.APIService;
import com.example.a84965.musicplayer.service.DataService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongListActivity extends AppCompatActivity {

    QuangCao quangCao;
    PlayList playList;
    CoordinatorLayout coordinatorLayoutSongList;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewSongList;
    ImageView imgSongList;
    FloatingActionButton floatingActionButton;
    ArrayList<BaiHat> listBaiHat;
    SongListAdapter songListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        initControls();
        checkDataIntent();
        init();
        if(quangCao != null && !quangCao.getTenbaihat().equals("")){
            setValueView(quangCao.getTenbaihat(),quangCao.getHinhanh(),quangCao.getHinhbaihat());
            getDataQuangCao(quangCao.getIdquangcao());
        }

        if(playList != null && !playList.getTen().equals("")){
            setValueView(playList.getTen(),playList.getHinh(),playList.getIcon());
            getDataPlaylist(playList.getId());

        }
    }



    private void setValueView(String ten,String hinhQuangCao , String hinhBaiHat) {
        collapsingToolbarLayout.setTitle(ten);
        LoadImageToCollapsingToolbarLayout loadImageToCollapsingToolbarLayout = new LoadImageToCollapsingToolbarLayout();
        loadImageToCollapsingToolbarLayout.execute(hinhQuangCao);
        Picasso.get()
                .load(hinhBaiHat)
                .into(imgSongList);
    }

    private void getDataQuangCao(String idQuangCao) {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callBack = dataService.getDanhSachBaiHatTheoQuangCao(idQuangCao);
        callBack.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                listBaiHat = (ArrayList<BaiHat>) response.body();
                songListAdapter = new SongListAdapter(SongListActivity.this,listBaiHat);
                recyclerViewSongList.setLayoutManager(new LinearLayoutManager(SongListActivity.this));
                recyclerViewSongList.setAdapter(songListAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }

    private void getDataPlaylist(String idPlaylist) {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callBack = dataService.getDanhSachBaiHatTheoPlaylist(idPlaylist);
        callBack.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                listBaiHat = (ArrayList<BaiHat>) response.body();
                songListAdapter = new SongListAdapter(SongListActivity.this,listBaiHat);
                recyclerViewSongList.setLayoutManager(new LinearLayoutManager(SongListActivity.this));
                recyclerViewSongList.setAdapter(songListAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }



    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void initControls() {
        coordinatorLayoutSongList = findViewById(R.id.coordinatorLayoutSongList);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarSongList);
        toolbar = findViewById(R.id.toolBarSongList);
        recyclerViewSongList = findViewById(R.id.recyclerViewSongList);
        floatingActionButton = findViewById(R.id.floatingActionButtonSongList);
        imgSongList = findViewById(R.id.imageViewSongList);
    }

    private void checkDataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("banner")){
                quangCao = (QuangCao)intent.getSerializableExtra("banner");
                Toast.makeText(this, quangCao.getTenbaihat(), Toast.LENGTH_SHORT).show();
            }

            if(intent.hasExtra("playlist")){
                playList = (PlayList) intent.getSerializableExtra("playlist");
                    Toast.makeText(this, playList.getTen(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class LoadImageToCollapsingToolbarLayout extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                return bitmap;
            } catch (MalformedURLException e) {
                return null;
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap != null){
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    collapsingToolbarLayout.setBackground(bitmapDrawable);
                }
                super.onPostExecute(bitmap);
            }
        }
    }
}




