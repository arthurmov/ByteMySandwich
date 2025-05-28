package com.pluralsight.model.food;

import com.pluralsight.model.interfaces.Priceable;

public class Chips implements Priceable {
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
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
