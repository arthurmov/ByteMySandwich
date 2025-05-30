package com.pluralsight.model.food.components;

import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.MenuItem;
import com.pluralsight.model.interfaces.Priceable;

import java.util.ArrayList;
import java.util.List;

public class Bread implements Priceable, Caloric, MenuItem {
    private String typeOfBread;
    private double price;
    private int calories;

    public Bread(String type, int calories) {
        this.typeOfBread = type;
        this.calories = calories;
    }

    public String getType() {
        return typeOfBread;
    }

    public double getPrice() {
        return price;
    }

    public static List<Bread> getAvailableBreads() {
        List<Bread> breads = new ArrayList<>();
        breads.add(new Bread("White", 150));
        breads.add(new Bread("Wheat", 140));
        breads.add(new Bread("Rye", 160));
        breads.add(new Bread("Wrap", 180));
        return breads;
    }

    @Override
    public double getValue() {
        return getPrice();
    }

    @Override
    public int getCalories() {
        return calories;
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
