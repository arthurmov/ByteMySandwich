package com.pluralsight.model.food;

import com.pluralsight.model.food.toppings.PremiumTopping;
import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.MenuItem;
import com.pluralsight.model.interfaces.Priceable;
import com.pluralsight.model.food.components.*;
import com.pluralsight.model.food.toppings.Topping;
import com.pluralsight.model.interfaces.Sizeable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Sandwich implements Priceable, Sizeable, Caloric, MenuItem {
    private Bread bread;
    private List<PremiumTopping> meatsAndCheeses;
    private List<Topping> toppings;
    private Sauce sauce;
    private Size size;
    private boolean isToasted;

    public Sandwich() {
        this.meatsAndCheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.isToasted = false;
    }


    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public List<PremiumTopping> getMeatsAndCheeses() {
        return meatsAndCheeses;
    }

    public void setMeatsAndCheeses(List<PremiumTopping> meatsAndCheeses) {
        this.meatsAndCheeses = meatsAndCheeses;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public double getValue() {
        double basePrice;

        switch (size.getName()) {
            case "4\"":
                basePrice = 5.50;
                break;
            case "8\"":
                basePrice = 7.00;
                break;
            case "12\"":
                basePrice = 8.50;
                break;
            default:
                basePrice = 0;
                break;
        }

        List<PremiumTopping> meats = meatsAndCheeses.stream()
                .filter(t -> t.getMenuCategory().equalsIgnoreCase("Meat"))
                .toList();

        List<PremiumTopping> cheeses = meatsAndCheeses.stream()
                .filter(t -> t.getMenuCategory().equalsIgnoreCase("Cheese"))
                .toList();

        double meatCost = !meats.isEmpty() ? 1.00 + (meats.size() - 1) * getExtraMeatPrice(size.getName()) : 0;
        double cheeseCost = !cheeses.isEmpty() ? 0.75 + (cheeses.size() - 1) * getExtraCheesePrice(size.getName()) : 0;

        return basePrice + meatCost + cheeseCost;
    }

    private double getExtraMeatPrice(String size) {
        double price = 0.0;

        switch (size) {
            case "4\"":
                price = 0.50;
                break;
            case "8\"":
                price = 1.00;
                break;
            case "12\"":
                price = 1.50;
                break;
            default:
                price = 0.0;
                break;
        }

        return price;
    }

    private double getExtraCheesePrice(String size) {
        double price = 0.0;

        switch (size) {
            case "4\"":
                price = 0.30;
                break;
            case "8\"":
                price = 0.60;
                break;
            case "12\"":
                price = 0.90;
                break;
            default:
                price = 0.0;
                break;
        }

        return price;
    }


    @Override
    public int getCalories() {
        int total = 0;
        total += bread.getCalories();
        total += sauce.getCalories();

        for (PremiumTopping pt : meatsAndCheeses) {
            total += pt.getCalories();
        }

        for (Topping t : toppings) {
            total += t.getCalories();
        }

        return total;
    }

    @Override
    public String getMenuName() {
        return "Custom Sandwich";
    }

    @Override
    public String getDescription() {
        return size.getName() + " " + bread.getType() + " sandwich" +
                (isToasted ? " (Toasted)" : "") +
                " with " + meatsAndCheeses.size() + " meat/cheese items, " +
                toppings.size() + " toppings, and " + sauce.getTypeOfSauce() + " sauce.";
    }

    @Override
    public String getMenuCategory() {
        return "Sandwich";
    }

    @Override
    public String toString() {
        return getDescription() + " | $" + String.format("%.2f", getValue()) +
                " | " + getCalories() + " cal";
    }
}
