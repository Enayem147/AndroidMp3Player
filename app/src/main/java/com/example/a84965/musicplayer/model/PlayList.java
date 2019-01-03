package com.example.a84965.musicplayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PlayList implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("hinh")
    @Expose
    private String hinh;
    @SerializedName("icon")
    @Expose
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}