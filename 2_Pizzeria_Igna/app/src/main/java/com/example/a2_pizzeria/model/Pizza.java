package com.example.a2_pizzeria.model;

public class Pizza {
    private String name;
    private String url;
    private float price;

    public Pizza(String name, String url, float price) {
        this.name = name;
        this.url = url;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public float getPrice(int size) {
        return price + size;
    }
}
