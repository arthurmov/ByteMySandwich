package com.pluralsight.model.food.components;

import com.pluralsight.model.food.toppings.Topping;

public class Sauce extends Topping {
    private String typeOfSauce;
    private double price;
    private int calories;

    public Sauce(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public String getMenuName() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getMenuCategory() {
        return "";
    }
}
