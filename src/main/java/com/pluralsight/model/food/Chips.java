package com.pluralsight.model.food;

import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.Flavored;
import com.pluralsight.model.interfaces.MenuItem;
import com.pluralsight.model.interfaces.Priceable;

import java.util.Arrays;
import java.util.List;

public class Chips implements Priceable, Caloric, MenuItem, Flavored {
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
    public List<String> getAvailableFlavors() {
        return Arrays.asList("Original", "Barbecue", "Sour Cream & Onion", "Salt & Vinegar", "Jalapeño");
    }

    @Override
    public double getValue() {
        return 1.50;
    }

    @Override
    public int getCalories() {
        switch (flavor.toLowerCase()) {
            case "original":
                return 150;
            case "barbecue":
                return 160;
            case "sour cream & onion":
                return 170;
            case "salt & vinegar":
                return 155;
            case "jalapeño":
                return 165;
            default:
                return 0;
        }
    }

    @Override
    public String getMenuName() {
        return flavor + " Chips";
    }

    @Override
    public String getDescription() {
        return "Crunchy " + flavor + " flavored chips.";
    }

    @Override
    public String getMenuCategory() {
        return "Chips";
    }
}
