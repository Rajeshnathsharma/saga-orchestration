package com.vinsguru.dto;

public class StockPrice {

    private String stock;
    private int price;

    public StockPrice(String stock, int price) {
        this.stock = stock;
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
