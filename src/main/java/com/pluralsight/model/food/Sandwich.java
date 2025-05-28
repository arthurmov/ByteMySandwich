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

public class Sandwich implements Priceable, Sizeable, Caloric, MenuItem {
    private Bread bread;
    private List<PremiumTopping> meatsAndCheeses;
    private List<Topping> toppings;
    private Sauce sauce;
    private Size size;
    private boolean isToasted;

    public Sandwich() {
//        this.bread = new Bread;
        this.meatsAndCheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
//        this.sauce = new Sauce;
//        this.size = new Size;
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
        double total = 0;
        total += bread.getPrice();
        total += size.getPriceMultiplier();

        for (PremiumTopping pt : meatsAndCheeses) {
            total += pt.getValue();
        }
        return total;
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
