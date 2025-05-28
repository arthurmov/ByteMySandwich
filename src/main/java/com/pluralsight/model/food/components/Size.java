package com.pluralsight.model.food.components;

import java.util.ArrayList;
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

    public static List<Size> getStandardSizes() {
        List<Size> sizes = new ArrayList<>();
        sizes.add(new Size("4\"", 1.0));
        sizes.add(new Size("8\"", 2.0));
        sizes.add(new Size("12\"", 3.0));
        return sizes;
    }
}
