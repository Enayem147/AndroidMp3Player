package com.example.a84965.musicplayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaiHat {

@SerializedName("id")
@Expose
private String id;
@SerializedName("ten")
@Expose
private String ten;
@SerializedName("hinh")
@Expose
private String hinh;
@SerializedName("casi")
@Expose
private String casi;
@SerializedName("link")
@Expose
private String link;
@SerializedName("luotThich")
@Expose
private String luotThich;

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

public String getCasi() {
return casi;
}

public void setCasi(String casi) {
this.casi = casi;
}

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

public String getLuotThich() {
return luotThich;
}

public void setLuotThich(String luotThich) {
this.luotThich = luotThich;
}

}