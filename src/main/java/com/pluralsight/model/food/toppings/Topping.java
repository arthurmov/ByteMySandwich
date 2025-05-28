package com.pluralsight.model.food.toppings;

import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.MenuItem;

public abstract class Topping implements MenuItem, Caloric {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract int getCalories();

    @Override
    public abstract String getMenuName();

    @Override
    public abstract String getDescription();

    @Override
    public abstract String getMenuCategory();
}
