package com.example.jsonstockv2;

public class StockData {

    private String id;
    private String price;

    public StockData(String id, String price) {
        this.id = id;
        this.price = price;
    }

    public String getPrice() { return price; }
    public void setPrice(String price) {this.price = price; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
