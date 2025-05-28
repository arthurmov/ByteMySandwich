package com.pluralsight.model.food;

import com.pluralsight.interfaces.Priceable;

public class Drink implements Priceable {
    private Drink size;
    private String flavor;

    public Drink(Drink size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public Drink getSize() {
        return size;
    }

    public void setSize(Drink size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
