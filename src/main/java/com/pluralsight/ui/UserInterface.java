package com.pluralsight.ui;

import com.pluralsight.console.ColorCodes;
import com.pluralsight.console.Console;

public class UserInterface {

    private static final Console console = new Console();

    public void homeScreen() {

        //loop to keep the menu running
        while (true) {
            String homeScreenPrompt = ColorCodes.RED + """
            --------------------------
                   HOME SCREEN
            --------------------------
            """ + ColorCodes.RESET + """
             [1]  Start a New Order
             [0]  Exit the Application
             
            Please select an option: 
            """;
            //handles user input
            int option = console.promptForInt(homeScreenPrompt);

            //process the user's request based on their command
            switch (option) {
                case 1:
                    System.out.println();
                    orderScreen();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid command, please try again.");
            }
        }
    }

    private void orderScreen() {

        while (true) {
            String orderScreenPrompt = ColorCodes.RED + """
            --------------------------
                    ORDER MENU
            --------------------------
            """ + ColorCodes.RESET + """
             Build your order
            
             [1]  Add Sandwich
             [2]  Add Drink
             [3]  Add Chips
             [4]  Proceed to Checkout
             [0]  Cancel Order (return to Home)
            
            Please select an option: 
            """;
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
        while (true) {
            //to do... user confirmation

            //to do... select bread type: white, wheat, rye or wrap

            //to do... select sandwich size: 4, 8 or 12

            //to do... add extra toppings
                // meat, cheese, other, select sauces

            //to do... selected toasted
        }
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


