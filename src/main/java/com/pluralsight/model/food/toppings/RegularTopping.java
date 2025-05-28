package com.pluralsight.model.food.toppings;

import com.pluralsight.model.interfaces.Priceable;

public class RegularTopping extends Topping implements Priceable {
    private String name;
    private int calories;

    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return 0;
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
