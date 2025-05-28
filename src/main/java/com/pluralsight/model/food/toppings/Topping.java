package com.pluralsight.model.food.toppings;

import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.MenuItem;
import com.pluralsight.model.interfaces.Priceable;

public abstract class Topping implements MenuItem, Caloric {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
