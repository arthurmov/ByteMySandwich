package com.pluralsight.model.food;

import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.Flavored;
import com.pluralsight.model.interfaces.MenuItem;
import com.pluralsight.model.interfaces.Priceable;
import com.pluralsight.model.food.components.Size;

import java.util.Arrays;
import java.util.List;

public class Drink implements Priceable, Caloric, MenuItem, Flavored {
    private Size size;
    private String flavor;

    public Drink(Size size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
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
        return Arrays.asList("Cola", "Lemon-Lime", "Root Beer", "Iced Tea", "Orange", "Water");
    }

    @Override
    public double getValue() {
        return 1.50 * size.getPriceMultiplier();
    }

    @Override
    public int getCalories() {
        // Basic example – you can customize per flavor later
        switch (flavor.toLowerCase()) {
            case "cola":
            case "root beer":
            case "orange":
                return (int) (150 * size.getPriceMultiplier());
            case "lemon-lime":
            case "iced tea":
                return (int) (120 * size.getPriceMultiplier());
            case "water":
                return 0;
            default:
                return 100;
        }
    }

    @Override
    public String getMenuName() {
        return " Drink";
    }

    @Override
    public String getDescription() {
        return "A refreshing " + flavor + " drink in size " + size.getName();
    }

    @Override
    public String getMenuCategory() {
        return "Drink";
    }
}
