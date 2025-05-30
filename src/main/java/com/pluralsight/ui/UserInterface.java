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
                            + ColorCodes.BRIGHT_YELLOW + "\n [1] " + ColorCodes.RESET + "🧾 Start a New Order\n"
                            + ColorCodes.BRIGHT_YELLOW + " [0] " + ColorCodes.RESET + "❌ Exit the Application\n\n"
                            + "👉 Please select an option: ";



            //handles user input
            int option = console.promptForInt(homeScreenPrompt);

            //process the user's request based on their command
            switch (option) {
                case 1:
                    System.out.println();
                    orderScreen();
                    break;
                case 0:
                    System.out.println(ColorCodes.BRIGHT_YELLOW + "\n👋 Goodbye ! Thanks for visiting Byte My Sandwich." + ColorCodes.RESET);
                    System.exit(0);
                default:
                    System.out.println(ColorCodes.RED + "❌ Invalid command, please try again." + ColorCodes.RESET);
            }
        }
    }

    private void orderScreen() {
        System.out.println(ColorCodes.BRIGHT_YELLOW + """
                            ══════════════════════════════════════════════
                                          👤 CUSTOMER INFO
                            ══════════════════════════════════════════════
                            """ + ColorCodes.RESET);

        String name = console.promptForString("Please enter your name for the order: ");
        Customer customer = new Customer(name);

        System.out.printf("\n\uD83C\uDF89 Welcome, %s! Let's start your order.\n\n", name);

        currentOrder = new Order(customer);

        while (true) {
            String orderScreenPrompt =
                    ColorCodes.BRIGHT_YELLOW + """
                            ══════════════════════════════════════════════
                                          🍽️  ORDER MENU
                            ══════════════════════════════════════════════
                            """ +
                            ColorCodes.BRIGHT_YELLOW + "\n [1] " + ColorCodes.RESET + "🥪  Add Sandwich\n" +
                            ColorCodes.BRIGHT_YELLOW + " [2] " + ColorCodes.RESET + "🥤  Add Drink\n" +
                            ColorCodes.BRIGHT_YELLOW + " [3] " + ColorCodes.RESET + "🍟  Add Chips\n" +
                            ColorCodes.BRIGHT_YELLOW + " [4] " + ColorCodes.RESET + "💵  Proceed to Checkout\n" +
                            ColorCodes.BRIGHT_YELLOW + " [0] " + ColorCodes.RESET + "❌  Return to Main Menu\n\n" +
                            "👉 Please select an option: ";


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
                    if (currentOrder == null || currentOrder.getOrderItems().isEmpty()) {
                        System.out.println(ColorCodes.RED + "❌ No items in the order. Please add something before checkout.\n" + ColorCodes.RESET);
                    } else {
                        checkoutScreen();
                    }
                    break;
                case 0:
                    System.out.println(ColorCodes.BRIGHT_YELLOW + "\nReturning to Main Menu...\n" + ColorCodes.RESET);
                    return;
                default:
                    System.out.println(ColorCodes.RED + "❌ Invalid command, please try again." + ColorCodes.RESET);
            }
        }
    }

    private void addSandwichScreen() {
        System.out.println(ColorCodes.BRIGHT_YELLOW + """
                            ══════════════════════════════════════════════
                                          🥪 BUILD YOUR SANDWICH
                            ══════════════════════════════════════════════
                            """ + ColorCodes.RESET);

        int customOrSignature = console.promptForInt(ColorCodes.BRIGHT_YELLOW + """
         [1] """ + ColorCodes.RESET + " Custom Sandwich\n" +
                ColorCodes.BRIGHT_YELLOW + "[2] " + ColorCodes.RESET + "Signature Sandwich\n\n" +
                "👉 Please select an option: ");

        if(customOrSignature == 1) {

            //select bread
            System.out.println(ColorCodes.BRIGHT_YELLOW + "\n🍞 Choose your bread:\n" + ColorCodes.RESET);
            List<Bread> breads = Bread.getAvailableBreads();
            for (int i = 0; i < breads.size(); i++) {
                System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[" + (i + 1) + "] " + ColorCodes.RESET + breads.get(i).getMenuName());
            }

            int breadIndex;
            while (true) {
                breadIndex = console.promptForInt("\n👉 Enter your choice: ") - 1;
                if (breadIndex >= 0 && breadIndex < breads.size()) {
                    break;
                }
                System.out.println(ColorCodes.RED + "❌ Invalid choice. Please try again." + ColorCodes.RESET);
            }

            Bread selectedBread = breads.get(breadIndex);

            //select size
            System.out.println(ColorCodes.BRIGHT_YELLOW + "\n📏 Select sandwich size:\n" + ColorCodes.RESET);
            List<Size> sizes = Size.getSandwichSizes();
            for (int i = 0; i < sizes.size(); i++) {
                System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[" + (i + 1) + "] " + ColorCodes.RESET + sizes.get(i).getName());
            }

            int sizeIndex;
            while (true) {
                sizeIndex = console.promptForInt("\n👉 Enter your choice: ") - 1;
                if (sizeIndex >= 0 && sizeIndex < sizes.size()) {
                    break;
                }
                System.out.println(ColorCodes.RED + "❌ Invalid selection. Please try again." + ColorCodes.RESET);
            }

            Size selectedSize = sizes.get(sizeIndex);


            //select premium topping
            System.out.println(ColorCodes.BRIGHT_YELLOW + "\n🧀🥩 Select premium toppings (Meats & Cheeses) — 💰 Extra cost!" + ColorCodes.RESET);
            System.out.println(ColorCodes.YELLOW + "Enter 0 to finish:\n" + ColorCodes.RESET);

            List<PremiumTopping> premiumToppings = PremiumTopping.getPremiumToppings();
            List<PremiumTopping> selectedPremium = new ArrayList<>();

            //display premium topping options
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
                    continue; // Skip anything not meat or cheese
                }

                System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[" + (i + 1) + "] " + ColorCodes.RESET + premiumToppings.get(i).getMenuName() + " (" + type + ")");
            }

            //selection prompt loop
            while (true) {
                int input = console.promptForInt("\n👉 Select a topping: ");
                if (input == 0) break;

                if (input >= 1 && input <= premiumToppings.size()) {
                    PremiumTopping chosen = premiumToppings.get(input - 1);
                    selectedPremium.add(chosen);
                    System.out.println(ColorCodes.GREEN + "✔️ Added: " + chosen.getMenuName() + ColorCodes.RESET);
                } else {
                    System.out.println(ColorCodes.RED + "❌ Invalid selection. Please try again." + ColorCodes.RESET);
                }
            }


            //add regular toppings
            List<RegularTopping> regularToppings = RegularTopping.getRegularToppings();
            List<RegularTopping> selectedRegular = new ArrayList<>();

            System.out.println(ColorCodes.BRIGHT_YELLOW + "\n🥬 Select regular toppings" + ColorCodes.RESET);
            System.out.println(ColorCodes.YELLOW + "Enter 0 to finish:\n" + ColorCodes.RESET);

            //display regular toppings with yellow numbers
            for (int i = 0; i < regularToppings.size(); i++) {
                System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[" + (i + 1) + "] " + ColorCodes.RESET + regularToppings.get(i).getMenuName());
            }

            //selection prompt loop
            while (true) {
                int input = console.promptForInt("\n👉 Choose a topping: ");
                if (input == 0) break;

                if (input >= 1 && input <= regularToppings.size()) {
                    RegularTopping chosen = regularToppings.get(input - 1);
                    selectedRegular.add(chosen);
                    System.out.println(ColorCodes.GREEN + "✔️ Added: " + chosen.getMenuName() + ColorCodes.RESET);
                } else {
                    System.out.println(ColorCodes.RED + "❌ Invalid selection. Please try again." + ColorCodes.RESET);
                }
            }


            //choose sauce
            List<Sauce> sauces = Sauce.getSauces();

            System.out.println(ColorCodes.BRIGHT_YELLOW + "\n🧃 Choose a sauce:\n" + ColorCodes.RESET);
            for (int i = 0; i < sauces.size(); i++) {
                System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[" + (i + 1) + "] " + ColorCodes.RESET + sauces.get(i).getMenuName());
            }

            int sauceIndex;
            while (true) {
                sauceIndex = console.promptForInt("\n👉 Enter your choice: ") - 1;
                if (sauceIndex >= 0 && sauceIndex < sauces.size()) break;
                System.out.println(ColorCodes.RED + "❌ Invalid choice. Please select a valid sauce." + ColorCodes.RESET);
            }
            Sauce selectedSauce = sauces.get(sauceIndex);

            //toasted
            System.out.println();
            System.out.println(ColorCodes.BRIGHT_YELLOW + "🔥 Toast your sandwich?\n" + ColorCodes.RESET);
            System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[1] " + ColorCodes.RESET + "Yes");
            System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[2] " + ColorCodes.RESET + "No");
            boolean toasted = console.promptForInt("\n👉 Enter your choice: ") == 1;

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

            System.out.println(ColorCodes.GREEN + "\n✅ Sandwich added to your order.\n" + ColorCodes.RESET);

        } else if (customOrSignature == 2){
            System.out.println(ColorCodes.BRIGHT_YELLOW + "\n\uD83E\uDD6A Signature Sandwiches:" + ColorCodes.RESET);
            int sig = console.promptForInt(ColorCodes.BRIGHT_YELLOW + """
             [1] """ + ColorCodes.RESET + " BLT\n" +
                    ColorCodes.BRIGHT_YELLOW + "[2] " + ColorCodes.RESET + "Philly Cheesesteak\n\n" +
                    "👉 Please select a signature sandwich: ");

            switch (sig) {
                case 1 -> currentOrder.addSandwich(new BLT());
                case 2 -> currentOrder.addSandwich(new PhillyCheeseSteak());
                default -> {
                    System.out.println(ColorCodes.RED + "❌ Invalid option, please try again." + ColorCodes.RESET);
                    return;
                }
            }

            System.out.println(ColorCodes.GREEN + "\n✅ Sandwich added to your order.\n" + ColorCodes.RESET);
        } else {
            System.out.println(ColorCodes.RED + "❌ Invalid selection. Returning to previous menu." + ColorCodes.RESET);
        }
    }

    private void addDrinkScreen() {
        System.out.println(ColorCodes.BRIGHT_YELLOW + """
                    \n══════════════════════════════════════════════
                                  🥤 CHOOSE YOUR DRINK
                    ══════════════════════════════════════════════
                    """ + ColorCodes.RESET);

        List<Size> sizes = Size.getDrinkSizes();
        for (int i = 0; i < sizes.size(); i++) {
            System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[" + (i + 1) + "] " + ColorCodes.RESET + sizes.get(i).getName());
        }

        int sizeIndex;
        while (true) {
            sizeIndex = console.promptForInt("\n📏 Select drink size: ") - 1;
            if (sizeIndex >= 0 && sizeIndex < sizes.size()) {
                break;
            }
            System.out.println(ColorCodes.RED + "❌ Invalid choice. Please select a valid drink size." + ColorCodes.RESET);
        }
        Size size = sizes.get(sizeIndex);

        System.out.println(ColorCodes.BRIGHT_YELLOW + "\n🧃 Select your drink flavor:\n" + ColorCodes.RESET);


        List<String> flavors = new Drink(null, "").getAvailableFlavors();
        for (int i = 0; i < flavors.size(); i++) {
            System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[" + (i + 1) + "] " + ColorCodes.RESET + flavors.get(i));
        }

        int flavorIndex;
        while (true) {
            flavorIndex = console.promptForInt("\n👉 Choose a flavor: ") - 1;
            if (flavorIndex >= 0 && flavorIndex < flavors.size()) {
                break;
            }
            System.out.println(ColorCodes.RED + "❌ Invalid choice. Please select a valid drink flavor." + ColorCodes.RESET);
        }

        String flavor = flavors.get(flavorIndex);
        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);

        System.out.println(ColorCodes.GREEN + "\n✅ Drink added to your order!\n" + ColorCodes.RESET);
    }


    private void addChipsScreen() {
        System.out.println(ColorCodes.BRIGHT_YELLOW + """
                        \n══════════════════════════════════════════════
                                      🍟 CHOOSE YOUR CHIPS
                        ══════════════════════════════════════════════
                        """ + ColorCodes.RESET);

        List<String> flavors = new Chips("").getAvailableFlavors();

        for (int i = 0; i < flavors.size(); i++) {
            System.out.println(" " + ColorCodes.BRIGHT_YELLOW + "[" + (i + 1) + "] " + ColorCodes.RESET + flavors.get(i));
        }

        int choice;
        while (true) {
            choice = console.promptForInt("\n👉 Please enter your choice: ") - 1;
            if (choice >= 0 && choice < flavors.size()) {
                break;
            }
            System.out.println(ColorCodes.RED + "❌ Invalid selection. Please try again." + ColorCodes.RESET);
        }

        Chips chips = new Chips(flavors.get(choice));
        currentOrder.addChips(chips);

        System.out.println(ColorCodes.GREEN + "\n✅ Chips added to your order!\n" + ColorCodes.RESET);
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

        int confirm;
        while (true) {
            confirm = console.promptForInt(
                    "\n✅ Confirm checkout? " +
                            ColorCodes.BRIGHT_YELLOW + "[1]" + ColorCodes.RESET + " Yes  " +
                            ColorCodes.BRIGHT_YELLOW + "[2]" + ColorCodes.RESET + " Cancel: "
            );
            if (confirm == 1 || confirm == 2) break;
            System.out.println(ColorCodes.RED + "❌ Invalid input. Please enter 1 or 2." + ColorCodes.RESET);
        }

        if (confirm == 1) {
            currentOrder.finalizeOrder();
            FileManager.saveReceiptToFile(currentOrder);
            System.out.println(ColorCodes.GREEN + "\n🎉 Order complete. Returning to home...\n" + ColorCodes.RESET);
            currentOrder = null; // clear order after saving
            homeScreen();
        } else {
            System.out.println(ColorCodes.RED + "❌ Order canceled." + ColorCodes.RESET);
            currentOrder = null;
            homeScreen();
        }
    }
}