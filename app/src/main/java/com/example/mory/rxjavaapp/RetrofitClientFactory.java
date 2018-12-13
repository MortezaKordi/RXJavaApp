package com.example.mory.rxjavaapp;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientFactory {


    private static Retrofit rcfInstance;

    public static Retrofit getInstance() {

        if (rcfInstance == null) {


            rcfInstance = new Retrofit.Builder()
                    .baseUrl("https://api.iextrading.com/1.0/stock/market/collection/sector?collectionName=Health%20Care")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return rcfInstance;
    }


    public RetrofitClientFactory() {
    }
}
