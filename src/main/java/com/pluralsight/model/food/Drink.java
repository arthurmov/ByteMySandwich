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
        double multiplier = size.getCalorieMultiplier();

        switch (flavor.toLowerCase()) {
            case "cola":
                return (int) (250 * multiplier);
            case "root beer":
                return (int) (300 * multiplier);
            case "orange":
                return (int) (150 * multiplier);
            case "lemon-lime":
                return (int) (165 * multiplier);
            case "iced tea":
                return (int) (120 * multiplier);
            case "water":
                return 0;
            default:
                return (int) (100 * multiplier);
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
