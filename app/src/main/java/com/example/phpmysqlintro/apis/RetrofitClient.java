package com.example.phpmysqlintro.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//created singleton class for retrofit
public class RetrofitClient {

    //private static final String BASE_URL = "http://192.168.43.150/MyApi/public/"; //When connecting with mobile hotspot and vysor
    private static final String BASE_URL = "http://192.168.0.104/MyApi/public/";
    private  Retrofit retrofit;
    private static RetrofitClient mInstance;

    private RetrofitClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //synchronized coz we only wants a single instance
    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}