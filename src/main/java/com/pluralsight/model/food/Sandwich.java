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
        return 0;
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public String getMenuName() {
        return "";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getMenuCategory() {
        return "";
    }
}
