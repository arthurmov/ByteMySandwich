package com.pluralsight.model.food.toppings;

import com.pluralsight.model.interfaces.Priceable;

public class PremiumTopping extends Topping implements Priceable {
    private String name;
    private double price;
    private boolean isExtra;
    private int calories;

    public PremiumTopping(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return 0;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
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
