package com.pluralsight.ui;

import com.pluralsight.model.customer.Customer;
import com.pluralsight.model.food.*;
import com.pluralsight.model.food.components.*;
import com.pluralsight.model.food.toppings.PremiumTopping;
import com.pluralsight.model.food.toppings.RegularTopping;
import com.pluralsight.model.food.toppings.Topping;
import com.pluralsight.model.order.Order;
import com.pluralsight.util.*;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private static final Console console = new Console();
    private Order currentOrder;

    public void homeScreen() {

        //loop to keep the menu running
        while (true) {
            String homeScreenPrompt = """
            \s
             [1]  Start a New Order
             [0]  Exit the Application
            \s
            Please select an option:\s
           \s""";
            //handles user input
            int option = console.promptForInt(homeScreenPrompt);

            //process the user's request based on their command
            switch (option) {
                case 1:
                    System.out.println();
                    orderScreen();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid command, please try again.");
            }
        }
    }

    private void orderScreen() {
        String name = console.promptForString("Enter your name for the order: ");
        Customer customer = new Customer(name);
        currentOrder = new Order(customer);


        currentOrder = new Order(customer);

        while (true) {
            String orderScreenPrompt = ColorCodes.RED + """
            --------------------------
                    ORDER MENU
            --------------------------
            """ + ColorCodes.RESET + """
             Build your order
           \s
             [1]  Add Sandwich
             [2]  Add Drink
             [3]  Add Chips
             [4]  Proceed to Checkout
             [0]  Cancel Order (return to Home)
           \s
            Please select an option:\s
           \s""";
            //handles user input
            int option = console.promptForInt(orderScreenPrompt);

            //process the user's request based on their command
            switch (option) {
                case 1:
                    addSandwichScreen();
                    break;
                case 2:
                    addDrinkScreen();
                    break;
                case 3:
                    addChipsScreen();
                    break;
                case 4:
                    checkoutScreen();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid command, please try again.");
            }
        }
    }

    private void addSandwichScreen() {
        System.out.println("Let's build your sandwich!");

        //select bread
        System.out.println("Select bread:");
        List<Bread> breads = Bread.getAvailableBreads();
        for (int i = 0; i < breads.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + breads.get(i).getMenuName());
        }
        int breadIndex = console.promptForInt("Enter choice: ") - 1;
        Bread selectedBread = breads.get(breadIndex);

        //select size
        List<Size> sizes = Size.getStandardSizes();
        for (int i = 0; i < sizes.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + sizes.get(i).getName());
        }
        int sizeIndex = console.promptForInt("Select sandwich size: ") - 1;
        if (sizeIndex < 0 || sizeIndex >= sizes.size()) {
            System.out.println("Invalid selection. Returning to previous menu.");
            return;
        }
        Size selectedSize = sizes.get(sizeIndex);


        //add premium toppings
        List<PremiumTopping> premiumToppings = PremiumTopping.getPremiumToppings();
        List<PremiumTopping> selectedPremium = new ArrayList<>();
        System.out.println("Select premium toppings (0 to finish):");
        while (true) {
            for (int i = 0; i < premiumToppings.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + premiumToppings.get(i).getMenuName());
            }
            int input = console.promptForInt("Choose topping: ");
            if (input == 0) break;
            selectedPremium.add(premiumToppings.get(input - 1));
        }

        //add regular toppings
        List<RegularTopping> regularToppings = RegularTopping.getRegularToppings();
        List<RegularTopping> selectedRegular = new ArrayList<>();
        System.out.println("Select regular toppings (0 to finish):");
        while (true) {
            for (int i = 0; i < regularToppings.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + regularToppings.get(i).getMenuName());
            }
            int input = console.promptForInt("Choose topping: ");
            if (input == 0) break;
            selectedRegular.add(regularToppings.get(input - 1));
        }

        //choose sauce
        List<Sauce> sauces = Sauce.getSauces();
        for (int i = 0; i < sauces.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + sauces.get(i).getMenuName());
        }
        int sauceIndex = console.promptForInt("Choose a sauce: ") - 1;
        Sauce selectedSauce = sauces.get(sauceIndex);

        //toasted
        boolean toasted = console.promptForInt("Toasted? [1] Yes [2] No: ") == 1;

        //create and save sandwich
        Sandwich sandwich = new Sandwich();
        sandwich.setSize(selectedSize);
        sandwich.setToasted(toasted);
        sandwich.setBread(selectedBread);
        sandwich.setSauce(selectedSauce);
        sandwich.setMeatsAndCheeses(selectedPremium);
        sandwich.setToppings(new ArrayList<Topping>(selectedRegular));

        //add to current order
        currentOrder.addSandwich(sandwich);

        System.out.println("Sandwich added to your order.\n");
    }


    private void addDrinkScreen() {
        // to do... user confirmation

        // to do... select size

        // to do... select flavor
    }

    private void addChipsScreen() {
        // to do... user confirmation

        // to do... select chip type
    }
    private void checkoutScreen() {
        //to do... display order details and price

        //to do... confirm - create receipt file and go back to home screen

        //to do... cancel - delete order and go back to home screen
    }

}


