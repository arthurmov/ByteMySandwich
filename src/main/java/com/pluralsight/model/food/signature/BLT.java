package com.pluralsight.model.food.signature;

import com.pluralsight.model.food.Sandwich;
import com.pluralsight.model.food.components.*;
import com.pluralsight.model.food.toppings.*;

import java.util.ArrayList;
import java.util.List;

public class BLT extends Sandwich {
    public BLT() {
        setSize(new Size("8\"", 1.0, 1.5));
        setBread(new Bread("White", 150));
        setToasted(true);
        setSauce(new Sauce("Ranch", 110));

        List<PremiumTopping> meatsAndCheeses = new ArrayList<>();
        meatsAndCheeses.add(new PremiumTopping("Bacon", 1));
        meatsAndCheeses.add(new PremiumTopping("Cheddar", .75));
        setMeatsAndCheeses(meatsAndCheeses);

        List<RegularTopping> toppings = new ArrayList<>();
        toppings.add(new RegularTopping("Lettuce"));
        toppings.add(new RegularTopping("Tomato"));
        setToppings(new ArrayList<>(toppings));
    }
}
