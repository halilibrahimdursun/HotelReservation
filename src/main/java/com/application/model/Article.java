package com.application.model;

import java.util.Arrays;

public class Article {

    long id;
    String name;
    String description;
    double price;
    byte[] image;
    int stock;

    public Article() {
    }

    public Article(String name, String description, double price, byte[] image, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image=" + Arrays.toString(image) +
                ", stock=" + stock +
                '}';
    }
}
