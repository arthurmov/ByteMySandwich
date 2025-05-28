package com.pluralsight.model.food;

import com.pluralsight.model.interfaces.Priceable;
import com.pluralsight.model.food.components.*;
import com.pluralsight.model.food.toppings.Topping;

import java.util.List;

public class Sandwich implements Priceable {
    private Bread bread;
    private Meat meat;
    private Cheese cheese;
    private List<Topping> toppings;
    private Sauce sauce;
    private Size size;

    public Sandwich(Bread bread, Meat meat, Cheese cheese, List<Topping> toppings, Sauce sauce, Size size) {
        this.bread = bread;
        this.meat = meat;
        this.cheese = cheese;
        this.toppings = toppings;
        this.sauce = sauce;
        this.size = size;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
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
}
