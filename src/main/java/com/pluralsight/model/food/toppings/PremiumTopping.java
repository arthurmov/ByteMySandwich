package com.pluralsight.model.food.toppings;

import com.pluralsight.model.interfaces.Priceable;

import java.util.ArrayList;
import java.util.List;

public class PremiumTopping extends Topping implements Priceable {
    private double price;
    private boolean isExtra;
    private int calories;

    public PremiumTopping(String name, double price) {
        super(name);
        this.price = price;
        this.isExtra = false;
        this.calories = estimateCalories(name);
    }

    public static List<PremiumTopping> getPremiumToppings() {
        List<PremiumTopping> list = new ArrayList<>();

        //meats
        list.add(new PremiumTopping("Steak", 1.00));
        list.add(new PremiumTopping("Ham", 1.00));
        list.add(new PremiumTopping("Salami", 1.00));
        list.add(new PremiumTopping("Roast Beef", 1.00));
        list.add(new PremiumTopping("Chicken", 1.00));
        list.add(new PremiumTopping("Bacon", 1.00));

        //cheeses
        list.add(new PremiumTopping("American", 0.75));
        list.add(new PremiumTopping("Provolone", 0.75));
        list.add(new PremiumTopping("Cheddar", 0.75));
        list.add(new PremiumTopping("Swiss", 0.75));

        return list;
    }

    private int estimateCalories(String name) {
        name = name.toLowerCase();
        int cals = 0;

        switch (name) {
            case "steak":
                cals = 180;
                break;
            case "ham":
                cals = 120;
                break;
            case "salami":
                cals = 150;
                break;
            case "roast beef":
                cals = 130;
                break;
            case "chicken":
                cals = 140;
                break;
            case "bacon":
                cals = 100;
                break;
            case "american":
                cals = 90;
                break;
            case "provolone":
                cals = 100;
                break;
            case "cheddar":
                cals = 110;
                break;
            case "swiss":
                cals = 105;
                break;
        }

        return cals;
    }

    @Override
    public double getValue() {
        return isExtra ? price / 2 : price;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
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
        return (isExtra ? "Extra " : "") + getName();
    }

    @Override
    public String getMenuCategory() {
        return "Premium Topping";
    }


}
