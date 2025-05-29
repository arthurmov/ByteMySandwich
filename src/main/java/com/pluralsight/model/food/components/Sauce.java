package com.pluralsight.model.food.components;

import com.pluralsight.model.food.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sauce extends Topping {
    private String typeOfSauce;
    private int calories;

    public Sauce(String name) {
        super(name);
        this.calories = estimateCalories(name);
    }

    public static List<Sauce> getSauces() {
        List<Sauce> sauces = new ArrayList<>();

        sauces.add(new Sauce("Mayo"));
        sauces.add(new Sauce("Mustard"));
        sauces.add(new Sauce("Ketchup"));
        sauces.add(new Sauce("Ranch"));
        sauces.add(new Sauce("Thousand Islands"));
        sauces.add(new Sauce("Vinaigrette"));

        return sauces;
    }

    private int estimateCalories(String name) {
        name = name.toLowerCase();
        int cals = 0;

        switch (name) {
            case "mayo":
                cals = 100;
                break;
            case "mustard":
                cals = 20;
                break;
            case "ketchup":
                cals = 25;
                break;
            case "ranch":
                cals = 110;
                break;
                case "thousand islands":
                cals = 90;
                break;
            case "vinaigrette":
                cals = 80;
                break;
        }

        return cals;
    }
    public String getTypeOfSauce() {
        return typeOfSauce;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String getMenuName() {
        return getName();
    }

    @Override
    public String getDescription() {
        return "Zesty " +getTypeOfSauce() + " sauce";
    }

    @Override
    public String getMenuCategory() {
        return "Sauce";
    }
}
