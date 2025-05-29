package com.pluralsight.model.food.signature;

import com.pluralsight.model.food.Sandwich;
import com.pluralsight.model.food.components.*;
import com.pluralsight.model.food.toppings.*;

import java.util.ArrayList;
import java.util.List;

public class BLT extends Sandwich {
    public BLT() {
        setSize(new Size("8\"", 1.0));
        setBread(new Bread("White"));
        setToasted(true);
        setSauce(new Sauce("Ranch"));

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
