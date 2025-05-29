package com.pluralsight.model.food.components;

import java.util.List;

public class Size {
    private String name;
    private double priceMultiplier;

    public Size(String name, double priceMultiplier) {
        this.name = name;
        this.priceMultiplier = priceMultiplier;
    }

    public String getName() {
        return name;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    //sandwich sizes
    public static List<Size> getSandwichSizes() {
        return List.of(
                new Size("4\"", 1.0),   // base
                new Size("8\"", 2.0),
                new Size("12\"", 3.0)
        );
    }

    //drink sizes
    public static List<Size> getDrinkSizes() {
        return List.of(
                new Size("Small", 1.0),
                new Size("Medium", 1.5),
                new Size("Large", 2.0)
        );
    }
}
