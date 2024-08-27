package com.example.junitdemo.chap03_02;

public class Order {
    private String id;
    private String itemName;

    public Order(String id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }

    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }
}
