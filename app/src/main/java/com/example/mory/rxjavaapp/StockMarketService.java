package com.example.mory.rxjavaapp;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface StockMarketService {



    // https://api.iextrading.com/1.0/stock/market/collection/sector?collectionName=Health%20Care
    String collectionName = "Health%20Care";
    @GET("sector?collectionName=" + collectionName)
    Observable<List<StockMarketItem>> emittedItems();




}
