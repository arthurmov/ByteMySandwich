package com.pluralsight.ui;

import com.pluralsight.model.customer.*;
import com.pluralsight.model.food.*;
import com.pluralsight.model.food.components.*;
import com.pluralsight.model.food.toppings.*;
import com.pluralsight.model.order.*;
import com.pluralsight.util.*;
import com.pluralsight.model.food.signature.*;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private static final Console console = new Console();
    private Order currentOrder;

    public void homeScreen() {

        //loop to keep the menu running
        while (true) {
            String homeScreenPrompt = ColorCodes.BRIGHT_YELLOW + """
                    ══════════════════════════════════════════════
                                    MAIN MENU 🍔
                    ══════════════════════════════════════════════
                    """ + ColorCodes.RESET
                    + ColorCodes.BRIGHT_YELLOW + " [1] " + ColorCodes.RESET + "🧾 Start a New Order\n"
                    + ColorCodes.BRIGHT_YELLOW + " [0] " + ColorCodes.RESET + "❌ Exit the Application\n\n"
                    + "Please select an option:\n";



            //handles user input
            int option = console.promptForInt(homeScreenPrompt);

            //process the user's request based on their command
            switch (option) {
                case 1:
                    System.out.println();
                    orderScreen();
                    break;
                case 0:
                    System.out.println(ColorCodes.BRIGHT_YELLOW + "👋 Goodbye ! Thanks for visiting Byte My Sandwich." + ColorCodes.RESET);
                    return;
                default:
                    System.out.println(ColorCodes.RED + "Invalid command, please try again." + ColorCodes.RESET);
            }
        }
    }

    private void orderScreen() {
        System.out.println(ColorCodes.BRIGHT_YELLOW + "══════════════════════════════════════════════");
        System.out.println("               👤 CUSTOMER INFO");
        System.out.println("══════════════════════════════════════════════" + ColorCodes.RESET);

        String name = console.promptForString("Please enter your name for the order: ");
        Customer customer = new Customer(name);

        System.out.printf("\n\uD83C\uDF89 Welcome, %s! Let's start your order.\n", name);

        currentOrder = new Order(customer);


        currentOrder = new Order(customer);

        while (true) {
            String orderScreenPrompt =
                    ColorCodes.BRIGHT_YELLOW + """
                            ══════════════════════════════════════════════
                                          🍽️  ORDER MENU
                            ══════════════════════════════════════════════
                            """ +
                            ColorCodes.BRIGHT_YELLOW + " [1] " + ColorCodes.RESET + "🥪  Add Sandwich\n" +
                            ColorCodes.BRIGHT_YELLOW + " [2] " + ColorCodes.RESET + "🥤  Add Drink\n" +
                            ColorCodes.BRIGHT_YELLOW + " [3] " + ColorCodes.RESET + "🍟  Add Chips\n" +
                            ColorCodes.BRIGHT_YELLOW + " [4] " + ColorCodes.RESET + "💵  Proceed to Checkout\n" +
                            ColorCodes.BRIGHT_YELLOW + " [0] " + ColorCodes.RESET + "❌  Cancel Order (Return to Home)\n\n" +
                            "Please select an option:\n";


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
                    System.out.println(ColorCodes.BRIGHT_YELLOW + "Returning to Main Menu...\n" + ColorCodes.RESET);
                    return;
                default:
                    System.out.println(ColorCodes.RED + "❌ Invalid command, please try again." + ColorCodes.RESET);
            }
        }
    }

    private void addSandwichScreen() {
        System.out.println("\n🥪 Let's build your sandwich!");

        int customOrSignature = console.promptForInt("""
                [1] Custom Sandwich
                [2] Signature Sandwich
                """);

        if(customOrSignature == 1) {

            //select bread
            System.out.println("\n🍞 Choose your bread:");
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
            int sizeIndex = console.promptForInt("\n📏 Select sandwich size:") - 1;
            if (sizeIndex < 0 || sizeIndex >= sizes.size()) {
                System.out.println(ColorCodes.RED + "❌ Invalid selection. Returning to previous menu." + ColorCodes.RESET);
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
                int input = console.promptForInt("\n🧀🥩 Select premium toppings (meats & cheeses) — 💰 Extra cost! (Enter 0 to finish)");
                if (input == 0) break;
                if (input >= 1 && input <= premiumToppings.size()) {
                    PremiumTopping chosen = premiumToppings.get(input - 1);
                    selectedPremium.add(chosen);
                    System.out.println("✔️ Added: " + chosen.getMenuName());
                } else {
                    System.out.println(ColorCodes.RED + "❌ Invalid selection. Try again." + ColorCodes.RESET);
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
                System.out.println(ColorCodes.RED + "❌ Invalid choice, try again." + ColorCodes.RESET);
            }
            Sauce selectedSauce = sauces.get(sauceIndex);

            //toasted
            boolean toasted = console.promptForInt("\n🔥 Toasted? [1] Yes [2] No: ") == 1;

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

            System.out.println(ColorCodes.GREEN + "✅ Sandwich added to your order.\n" + ColorCodes.RESET);
        } else {
            int signatureSandwichType = console.promptForInt("""
                    [1] BLT
                    [2] Philly Cheesesteak
                    """);

            switch (signatureSandwichType) {
                case 1:
                    currentOrder.addSandwich(new BLT());
                    System.out.println(ColorCodes.GREEN + "✅ Sandwich added to your order.\n" + ColorCodes.RESET);
                    break;
                case 2:
                    currentOrder.addSandwich(new PhillyCheeseSteak());
                    System.out.println(ColorCodes.GREEN + "✅ Sandwich added to your order.\n" + ColorCodes.RESET);
                    break;
                default:
                    System.out.println(ColorCodes.RED + "❌ Invalid option, please try again." + ColorCodes.RESET);
                    break;
            }
        }
    }

    private void addDrinkScreen() {
        System.out.println("\n🥤 Select your drink size:");
        List<Size> sizes = Size.getDrinkSizes();
        for (int i = 0; i < sizes.size(); i++) {
            System.out.println(" [" + (i + 1) + "] " + sizes.get(i).getName());
        }

        int sizeIndex;
        while (true) {
            sizeIndex = console.promptForInt("Choice: ") - 1;
            if (sizeIndex >= 0 && sizeIndex < sizes.size()) {
                break;
            }
            System.out.println(ColorCodes.RED + "❌ Invalid choice. Please select a valid drink size." + ColorCodes.RESET);
        }
        Size size = sizes.get(sizeIndex);

        System.out.println("\n🧃 Available Flavors:");
        List<String> flavors = new Drink(null, "").getAvailableFlavors();
        for (int i = 0; i < flavors.size(); i++) {
            System.out.println(" [" + (i + 1) + "] " + flavors.get(i));
        }

        int flavorIndex;
        while (true) {
            flavorIndex = console.promptForInt("Choose a flavor: ") - 1;
            if (flavorIndex >= 0 && flavorIndex < flavors.size()) {
                break;
            }
            System.out.println(ColorCodes.RED + "❌ Invalid choice. Please select a valid drink flavor." + ColorCodes.RESET);
        }

        String flavor = flavors.get(flavorIndex);
        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);

        System.out.println(ColorCodes.GREEN + "✅ Drink added to your order.\n" + ColorCodes.RESET);
    }


    private void addChipsScreen() {
        System.out.println(ColorCodes.YELLOW + "\n🍟 Select your chips flavor:" + ColorCodes.RESET);
        List<String> flavors = new Chips("").getAvailableFlavors();

        for (int i = 0; i < flavors.size(); i++) {
            System.out.println(" [" + (i + 1) + "] " + flavors.get(i));
        }

        int choice;
        while (true) {
            choice = console.promptForInt("👉 Enter your choice: ") - 1;
            if (choice >= 0 && choice < flavors.size()) {
                break;
            }
            System.out.println(ColorCodes.RED + "❌ Invalid selection. Please try again." + ColorCodes.RESET);
        }

        Chips chips = new Chips(flavors.get(choice));
        currentOrder.addChips(chips);

        System.out.println(ColorCodes.GREEN + "✅ Chips added to your order!\n" + ColorCodes.RESET);
    }


    private void checkoutScreen() {
        System.out.println("\n🧾 Your Order Summary");
        System.out.println(ColorCodes.BRIGHT_YELLOW + "-------------------------------" + ColorCodes.RESET);

        for (Object item : currentOrder.getOrderItems()) {
            System.out.println(" - " + item.toString());
        }

        System.out.println(ColorCodes.BRIGHT_YELLOW + "-------------------------------" + ColorCodes.RESET);
        System.out.printf("💵 Total: $%.2f\n", currentOrder.calculateTotal());
        System.out.printf("🔥 Calories: %d cal\n", currentOrder.getTotalCalories());

        int confirm = console.promptForInt("\n✅ Confirm checkout? [1] Yes [2] Cancel: ");
        if (confirm == 1) {
            FileManager.saveReceiptToFile(currentOrder);
            System.out.println(ColorCodes.GREEN + "🎉 Order complete. Returning to home..." + ColorCodes.RESET);
        } else {
            System.out.println(ColorCodes.RED + "❌ Order canceled." + ColorCodes.RESET);
        }
    }

}


