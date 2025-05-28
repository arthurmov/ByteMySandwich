package com.pluralsight.model.food.components;

import com.pluralsight.model.interfaces.Priceable;

public class Bread implements Priceable {
    private String type;
    private double price;

    public Bread(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
