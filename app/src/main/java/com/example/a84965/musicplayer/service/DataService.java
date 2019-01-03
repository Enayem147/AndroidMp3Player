package com.example.a84965.musicplayer.service;

import com.example.a84965.musicplayer.model.Album;
import com.example.a84965.musicplayer.model.BaiHat;
import com.example.a84965.musicplayer.model.PlayList;
import com.example.a84965.musicplayer.model.QuangCao;
import com.example.a84965.musicplayer.model.TheLoaiChuDe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("initQuangCao.php")
    Call<List<QuangCao>> getDataPanner();

    @GET("initPlayListForCurrentDay.php")
    Call<List<PlayList>> getPlayListForCurrentDay();

    @GET("initTheLoaiChuDe.php")
    Call<TheLoaiChuDe> getTheLoaiChuDe();

    @GET("initAlbum.php")
    Call<List<Album>> getAlbum();

    @GET("initBaiHatYeuThich.php")
    Call<List<BaiHat>> getBaiHatYeuThich();

    @FormUrlEncoded
    @POST("initDanhSachBaiHat.php")
    Call<List<BaiHat>> getDanhSachBaiHatTheoQuangCao(@Field("idQuangCao") String idQuangCao);

    @FormUrlEncoded
    @POST("initDanhSachBaiHat.php")
    Call<List<BaiHat>> getDanhSachBaiHatTheoPlaylist(@Field("idPlayList") String idPlayList);
}
