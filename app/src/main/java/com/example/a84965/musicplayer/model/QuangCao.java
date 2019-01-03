package com.example.a84965.musicplayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuangCao implements Serializable {

    @SerializedName("idquangcao")
    @Expose
    private String idquangcao;
    @SerializedName("hinhanh")
    @Expose
    private String hinhanh;
    @SerializedName("noidung")
    @Expose
    private String noidung;
    @SerializedName("idbaihat")
    @Expose
    private String idbaihat;
    @SerializedName("tenbaihat")
    @Expose
    private String tenbaihat;
    @SerializedName("hinhbaihat")
    @Expose
    private String hinhbaihat;

    public String getIdquangcao() {
        return idquangcao;
    }

    public void setIdquangcao(String idquangcao) {
        this.idquangcao = idquangcao;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getIdbaihat() {
        return idbaihat;
    }

    public void setIdbaihat(String idbaihat) {
        this.idbaihat = idbaihat;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getHinhbaihat() {
        return hinhbaihat;
    }

    public void setHinhbaihat(String hinhbaihat) {
        this.hinhbaihat = hinhbaihat;
    }

}