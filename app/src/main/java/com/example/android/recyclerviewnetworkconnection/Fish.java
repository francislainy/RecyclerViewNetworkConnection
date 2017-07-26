package com.example.android.recyclerviewnetworkconnection;

/**
 * Created by Francislainy on 26/07/2017.
 */

public class Fish {

    private String image;
    private String fish_name;
    private String category;
    private String size;
    private int price;

    public Fish(String image, String fish_name, String category, String size, int price) {
        this.image = image;
        this.fish_name = fish_name;
        this.category = category;
        this.size = size;
        this.price = price;
    }

    public Fish(String fish_name) {
        this.fish_name = fish_name;
    }

    public String getImage() {
        return image;
    }

    public String getFish_name() {
        return fish_name;
    }

    public String getCategory() {
        return category;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setFish_name(String fish_name) {
        this.fish_name = fish_name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
