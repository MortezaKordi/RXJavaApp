package com.example.mory.rxjavaapp;

import java.math.BigDecimal;

public class StockMarketItem {


    private String symbol;
    private String sector;
    private BigDecimal latestPrice;
    private String date;

    public StockMarketItem(String symbol, String sector, BigDecimal latestPrice, String date) {
        this.symbol = symbol;
        this.sector = sector;
        this.latestPrice = latestPrice;
        this.date = date;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSector() {
        return sector;
    }

    public BigDecimal getLatestPrice() {
        return latestPrice;
    }

    public String getDate() {
        return date;
    }
}
