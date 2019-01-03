package com.example.a84965.musicplayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TheLoai {

@SerializedName("idtheloai")
@Expose
private String idtheloai;
@SerializedName("idkeychude")
@Expose
private String idkeychude;
@SerializedName("tentheloai")
@Expose
private String tentheloai;
@SerializedName("hinhtheloai")
@Expose
private String hinhtheloai;

public String getIdtheloai() {
return idtheloai;
}

public void setIdtheloai(String idtheloai) {
this.idtheloai = idtheloai;
}

public String getIdkeychude() {
return idkeychude;
}

public void setIdkeychude(String idkeychude) {
this.idkeychude = idkeychude;
}

public String getTentheloai() {
return tentheloai;
}

public void setTentheloai(String tentheloai) {
this.tentheloai = tentheloai;
}

public String getHinhtheloai() {
return hinhtheloai;
}

public void setHinhtheloai(String hinhtheloai) {
this.hinhtheloai = hinhtheloai;
}

}