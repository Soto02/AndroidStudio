package com.example.a2_pizzeria.model;

public class Ingredient {
    private String name;
    private float price;

    public Ingredient(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
