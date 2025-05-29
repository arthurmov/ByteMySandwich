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
        String name = console.promptForString("Enter your name for the order: \n");
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
        List<Size> sizes = Size.getSandwichSizes();
        for (int i = 0; i < sizes.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + sizes.get(i).getName());
        }
        int sizeIndex = console.promptForInt("Select sandwich size: ") - 1;
        if (sizeIndex < 0 || sizeIndex >= sizes.size()) {
            System.out.println("Invalid selection. Returning to previous menu.");
            return;
        }
        Size selectedSize = sizes.get(sizeIndex);

        System.out.println("Select premium toppings (Meats & Cheeses). These cost extra. Enter 0 to finish:");

        List<PremiumTopping> premiumToppings = PremiumTopping.getPremiumToppings();
        List<PremiumTopping> selectedPremium = new ArrayList<>();

        //add premium options
        for (int i = 0; i < premiumToppings.size(); i++) {
            String name = premiumToppings.get(i).getName().toLowerCase();
            String type;

            if (name.equals("steak") || name.equals("ham") || name.equals("salami") ||
                    name.equals("roast beef") || name.equals("chicken") || name.equals("bacon")) {
                type = "Meat";
            } else if (name.equals("american") || name.equals("provolone") ||
                    name.equals("cheddar") || name.equals("swiss")) {
                type = "Cheese";
            } else {
                continue; //skip anything not meat or cheese
            }

            System.out.println("[" + (i + 1) + "] " + premiumToppings.get(i).getMenuName() + " (" + type + ")");
        }

        while (true) {
            int input = console.promptForInt("Choose a premium topping (0 to finish): ");
            if (input == 0) break;
            if (input >= 1 && input <= premiumToppings.size()) {
                PremiumTopping chosen = premiumToppings.get(input - 1);
                selectedPremium.add(chosen);
                System.out.println("Added: " + chosen.getMenuName());
            } else {
                System.out.println("Invalid selection. Try again.");
            }
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
            if (input == 0)
                break;
            selectedRegular.add(regularToppings.get(input - 1));
        }

        //choose sauce
        List<Sauce> sauces = Sauce.getSauces();
        for (int i = 0; i < sauces.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + sauces.get(i).getMenuName());
        }
        int sauceIndex;
        while (true) {
            sauceIndex = console.promptForInt("Choose a sauce (1-" + sauces.size() + "): ") - 1;
            if (sauceIndex >= 0 && sauceIndex < sauces.size())
                break;
            System.out.println("Invalid choice, try again.");
        }
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
        System.out.println("Select your drink size:");
        List<Size> sizes = Size.getDrinkSizes();
        for (int i = 0; i < sizes.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + sizes.get(i).getName());
        }

        int sizeIndex = console.promptForInt("Choice: ") - 1;
        Size size = sizes.get(sizeIndex);

        System.out.println("Available Flavors:");
        List<String> flavors = new Drink(null, "").getAvailableFlavors();
        for (int i = 0; i < flavors.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + flavors.get(i));
        }
        int flavorIndex = console.promptForInt("Choose a flavor: ") - 1;
        String flavor = flavors.get(flavorIndex);

        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);

        System.out.println("Drink added to your order.\n");
    }

    private void addChipsScreen() {
        System.out.println("Select your chips:");
        List<String> flavors = new Chips("").getAvailableFlavors();
        for (int i = 0; i < flavors.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + flavors.get(i));
        }
        int choice = console.promptForInt("Choose a flavor: ") - 1;
        Chips chips = new Chips(flavors.get(choice));
        currentOrder.addChips(chips);

        System.out.println("Chips added to your order.\n");
    }

    private void checkoutScreen() {
        System.out.println("Your order:");
        for (Object item : currentOrder.getOrderItems()) {
            System.out.println("- " + item.toString());
        }

        System.out.println("Total: $" + currentOrder.calculateTotal());

        int confirm = console.promptForInt("Confirm checkout? [1] Yes [2] Cancel: ");
        if (confirm == 1) {
            FileManager.saveReceiptToFile(currentOrder);
            System.out.println("Order complete. Returning to home...");
        } else {
            System.out.println("Order canceled.");
        }
    }
}


