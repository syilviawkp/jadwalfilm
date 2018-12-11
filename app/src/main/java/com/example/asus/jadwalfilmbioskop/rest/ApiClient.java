package com.example.asus.jadwalfilmbioskop.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.71.104:8282/tubes_enterprise/index.php/";
    public static final String BASE_upload = "http://192.168.71.104:8282/tubes_enterprise/assets/upload/";

    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
