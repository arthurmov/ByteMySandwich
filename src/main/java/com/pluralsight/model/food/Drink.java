package com.pluralsight.model.food;

import com.pluralsight.model.interfaces.*;
import com.pluralsight.model.food.components.Size;

import java.util.Arrays;
import java.util.List;

public class Drink implements Priceable, Caloric, MenuItem, Flavored, Sizeable {
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
        switch (size.getName().toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0.0;
        }
    }

    @Override
    public int getCalories() {
        switch (flavor.toLowerCase()) {
            case "cola":
                return 250;
            case "root beer":
                return 300;
            case "orange":
                return (int) (150 * size.getPriceMultiplier());
            case "lemon-lime":
                return 165;
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

    @Override
    public String toString() {
        return getDescription() + String.format(" | $%.2f | %d cal", getValue(), getCalories());
    }

}
