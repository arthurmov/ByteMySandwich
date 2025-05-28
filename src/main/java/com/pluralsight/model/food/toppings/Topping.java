package com.pluralsight.model.food.toppings;

import com.pluralsight.interfaces.Priceable;

public abstract class Topping implements Priceable {
    private String name;

    @Override
    public double getValue() {
        return 0;
    }
}
