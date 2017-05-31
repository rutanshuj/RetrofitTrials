package com.example.admin.mvcproject.rest;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageClient {
    public static final String BASE_URL = "https://rjhaveri41.000webhostapp.com";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit == null){
           retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
        }
        return retrofit;
    }
}
