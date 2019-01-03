package com.example.a84965.musicplayer.service;

public class APIService  {
    private static String baseUrl = "https://mp3playermobileapp.000webhostapp.com/Server/";
    public static DataService getService(){
        return APIRetrofitClient.getClient(baseUrl).create(DataService.class);
    }
}
