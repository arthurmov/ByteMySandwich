package com.pluralsight.model.food.components;

import com.pluralsight.model.food.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sauce extends Topping {
    private String typeOfSauce;
    private int calories;

    public Sauce(String name, int calories) {
        super(name);
        this.calories = calories;
    }

    public static List<Sauce> getSauces() {
        List<Sauce> sauces = new ArrayList<>();

        sauces.add(new Sauce("Mayo", 100));
        sauces.add(new Sauce("Mustard", 10));
        sauces.add(new Sauce("Ketchup", 20));
        sauces.add(new Sauce("Ranch", 110));
        sauces.add(new Sauce("Thousand Islands", 120));
        sauces.add(new Sauce("Vinaigrette", 80));

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