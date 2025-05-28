package com.pluralsight.model.food.toppings;

import com.pluralsight.model.interfaces.Priceable;

import java.util.ArrayList;
import java.util.List;

public class RegularTopping extends Topping implements Priceable {
    private int calories;

    public RegularTopping(String name) {
        super(name);
        this.calories = estimateCalories(name);
    }

    public static List<RegularTopping> getRegularToppings() {
        List<RegularTopping> list = new ArrayList<>();
        list.add(new RegularTopping("Lettuce"));
        list.add(new RegularTopping("Peppers"));
        list.add(new RegularTopping("Onions"));
        list.add(new RegularTopping("Tomatoes"));
        list.add(new RegularTopping("Jalapeños"));
        list.add(new RegularTopping("Cucumbers"));
        list.add(new RegularTopping("Pickles"));
        list.add(new RegularTopping("Guacamole"));
        list.add(new RegularTopping("Mushrooms"));
        return list;
    }


    private int estimateCalories(String name) {
        name = name.toLowerCase();
        int cals = 0;

        switch (name) {
            case "lettuce":
                cals = 2;
                break;
            case "peppers":
                cals = 5;
                break;
            case "onions":
                cals = 10;
                break;
            case "tomatoes":
                cals = 5;
                break;
            case "jalapeños":
                cals = 4;
                break;
            case "cucumbers":
                cals = 4;
                break;
            case "pickles":
                cals = 5;
                break;
            case "guacamole":
                cals = 45;
                break;
            case "mushrooms":
                cals = 5;
                break;
        }

        return cals;
    }

    @Override
    public double getValue() {
        return 0;
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
        return "Fresh " + getName();
    }

    @Override
    public String getMenuCategory() {
        return "Regular Topping";
    }
}
