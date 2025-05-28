package com.pluralsight.model.food;

import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.Flavored;
import com.pluralsight.model.interfaces.MenuItem;
import com.pluralsight.model.interfaces.Priceable;

import java.util.List;

public class Chips implements Priceable, Caloric, MenuItem, Flavored {
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
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
