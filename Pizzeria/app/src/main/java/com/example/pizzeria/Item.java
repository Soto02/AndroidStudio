package com.example.pizzeria;

import android.graphics.drawable.Drawable;

public class Item {

    private Drawable imageSrc;
    private String name;

    public Item(Drawable imageSrc, String name) {
        this.imageSrc = imageSrc;
        this.name = name;
    }

    public Drawable getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(Drawable imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
