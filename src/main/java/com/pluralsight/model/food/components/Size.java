package com.pluralsight.model.food.components;

import java.util.List;

public class Size {
    private String name;
    private double priceMultiplier;
    private double calorieMultiplier;

    public Size(String name, double priceMultiplier, double calorieMultiplier) {
        this.name = name;
        this.priceMultiplier = priceMultiplier;
        this.calorieMultiplier = calorieMultiplier;
    }

    public String getName() {
        return name;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public double getCalorieMultiplier() {
        return calorieMultiplier;
    }

    //sandwich sizes
    public static List<Size> getSandwichSizes() {
        return List.of(
                new Size("4\"", 1.0, 1.0),   // base
                new Size("8\"", 2.0, 1.5),
                new Size("12\"", 3.0, 2.0)
        );
    }

    //drink sizes
    public static List<Size> getDrinkSizes() {
        return List.of(
                new Size("Small", 1.0, 1.0),
                new Size("Medium", 1.5, 1.5),
                new Size("Large", 2.0, 2.0)
        );
    }
}
