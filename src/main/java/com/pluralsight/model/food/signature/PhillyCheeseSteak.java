package com.pluralsight.model.food.signature;

import com.pluralsight.model.food.Sandwich;
import com.pluralsight.model.food.components.*;
import com.pluralsight.model.food.toppings.*;

import java.util.ArrayList;
import java.util.List;

public class PhillyCheeseSteak extends Sandwich {
    public PhillyCheeseSteak() {
        setSize(new Size("8\"", 1));
        setBread(new Bread("white"));
        setSauce(new Sauce("Mayo"));
        setToasted(true);

        List<PremiumTopping> meatsAndCheeses = new ArrayList<>();
        meatsAndCheeses.add(new PremiumTopping("Steak", 1));
        meatsAndCheeses.add(new PremiumTopping("American Cheese", .75));
        setMeatsAndCheeses(meatsAndCheeses);

        List<RegularTopping> toppings = new ArrayList<>();
        toppings.add(new RegularTopping("Peppers"));
        setToppings(new ArrayList<>(toppings));
    }
}
