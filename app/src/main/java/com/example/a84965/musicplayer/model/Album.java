package com.example.a84965.musicplayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

@SerializedName("id")
@Expose
private String id;
@SerializedName("ten")
@Expose
private String ten;
@SerializedName("casi")
@Expose
private String casi;
@SerializedName("hinh")
@Expose
private String hinh;

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

public String getCasi() {
return casi;
}

public void setCasi(String casi) {
this.casi = casi;
}

public String getHinh() {
return hinh;
}

public void setHinh(String hinh) {
this.hinh = hinh;
}

}