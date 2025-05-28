package com.pluralsight.model.food;

import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.Flavored;
import com.pluralsight.model.interfaces.MenuItem;
import com.pluralsight.model.interfaces.Priceable;

import java.util.List;

public class Drink implements Priceable, Caloric, MenuItem, Flavored {
    private Drink size;
    private String flavor;

    public Drink(Drink size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public Drink getSize() {
        return size;
    }

    public void setSize(Drink size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public List<String> getAvailableFlavors() {
        return List.of();
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
