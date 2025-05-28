package com.pluralsight.model.food.components;

import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.MenuItem;
import com.pluralsight.model.interfaces.Priceable;

import java.util.ArrayList;
import java.util.List;

public class Bread implements Priceable, Caloric, MenuItem {
    private String typeOfBread;
    private double price;

    public Bread(String type) {
        this.typeOfBread = type;
    }

    public String getType() {
        return typeOfBread;
    }

    public double getPrice() {
        return price;
    }

    private int estimateCalories(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "white":
                return 150;
            case "wheat":
                return 140;
            case "rye":
                return 160;
            case "wrap":
                return 180;
            default:
                return 0;
        }
    }

    public static List<Bread> getAvailableBreads() {
        List<Bread> breads = new ArrayList<>();
        breads.add(new Bread("White"));
        breads.add(new Bread("Wheat"));
        breads.add(new Bread("Rye"));
        breads.add(new Bread("Wrap"));
        return breads;
    }

    @Override
    public double getValue() {
        return getPrice();
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public String getMenuName() {
        return typeOfBread + " Bread";
    }

    @Override
    public String getDescription() {
        return "Fresh " + typeOfBread + " bread";
    }

    @Override
    public String getMenuCategory() {
        return "Bread";
    }
}
