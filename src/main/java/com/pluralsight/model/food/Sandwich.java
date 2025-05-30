package com.pluralsight.model.food;

import com.pluralsight.model.food.toppings.*;
import com.pluralsight.model.interfaces.*;
import com.pluralsight.model.food.components.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        double total;
        switch (size.getName()) {
            case "4\"":
                total = 5.50;
                break;
            case "8\"":
                total = 7.00;
                break;
            case "12\"":
                total = 8.50;
                break;
            default:
                total = 5.50;
                break;
        }

        String sizeLabel = size.getName();

        int meatCount = 0;
        int cheeseCount = 0;

        for (PremiumTopping pt : meatsAndCheeses) {
            String name = pt.getName().toLowerCase();
            if (Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon").contains(name)) {
                meatCount++;
            } else {
                cheeseCount++;
            }
        }

        if (meatCount > 0) {
            total += getFirstMeatPrice(sizeLabel);
            total += (meatCount - 1) * getExtraMeatPrice(sizeLabel);
        }

        if (cheeseCount > 0) {
            total += getFirstCheesePrice(sizeLabel);
            total += (cheeseCount - 1) * getExtraCheesePrice(sizeLabel);
        }

        return total;
    }

    private double getFirstMeatPrice(String size) {
        double price;
        switch (size) {
            case "4\"":
                price = 1.00;
                break;
            case "8\"":
                price = 2.00;
                break;
            case "12\"":
                price = 3.00;
                break;
            default:
                price = 0.0;
                break;
        }
        return price;
    }

    private double getExtraMeatPrice(String size) {
        double price;
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

    private double getFirstCheesePrice(String size) {
        double price;
        switch (size) {
            case "4\"":
                price = 0.75;
                break;
            case "8\"":
                price = 1.50;
                break;
            case "12\"":
                price = 2.25;
                break;
            default:
                price = 0.0;
                break;
        }
        return price;
    }

    private double getExtraCheesePrice(String size) {
        double price;
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
        double multiplier = size.getCalorieMultiplier();
        int total = bread.getCalories();

        //bread base calories
        if (bread != null) {
            total += bread.getCalories();
        }

        //premium toppings (meats and cheeses)
        for (Topping mc : meatsAndCheeses) {
            total += mc.getCalories();
        }

        //regular toppings
        for (Topping topping : toppings) {
            total += topping.getCalories();
        }

        //sauce
        if (sauce != null) {
            total += sauce.getCalories();
        }

        //apply size multiplier to scale the sandwich
        return (int) (total * multiplier);
    }



    @Override
    public String getMenuName() {
        return "Custom Sandwich";
    }

    @Override
    public String getDescription() {
        StringBuilder desc = new StringBuilder();

        desc.append(size.getName()).append(" ")
                .append(bread.getMenuName()).append(" sandwich");
        desc.append(isToasted ? " (Toasted)" : " (Not Toasted)");

        List<String> meats = new ArrayList<>();
        List<String> cheeses = new ArrayList<>();

        for (PremiumTopping pt : meatsAndCheeses) {
            String name = pt.getName().toLowerCase();
            if (Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon").contains(name)) {
                meats.add(pt.getMenuName());
            } else {
                cheeses.add(pt.getMenuName());
            }
        }

        if (!meats.isEmpty()) desc.append(" | Meats: ").append(String.join(", ", meats));
        if (!cheeses.isEmpty()) desc.append(" | Cheeses: ").append(String.join(", ", cheeses));

        if (!toppings.isEmpty()) {
            List<String> regulars = toppings.stream().map(Topping::getMenuName).toList();
            desc.append(" | Toppings: ").append(String.join(", ", regulars));
        }

        if (sauce != null) {
            desc.append(" | Sauce: ").append(sauce.getMenuName());
        }

        desc.append(" | $").append(String.format("%.2f", getValue()));
        desc.append(" | ").append(getCalories()).append(" cal");

        return desc.toString();
    }

    @Override
    public String getMenuCategory() {
        return "Sandwich";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
