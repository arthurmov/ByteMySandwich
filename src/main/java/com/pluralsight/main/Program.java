package com.pluralsight.main;

import com.pluralsight.console.ColorCodes;
import com.pluralsight.ui.UserInterface;

public class Program {
    public static void main(String[] args) {

        System.out.println(ColorCodes.RED + """ 
                  
 ___  __   __  _____   ___     __  __  __   __    ___     _     _  _   ___   __      __  ___    ___   _  _\s
| _ ) \\ \\ / / |_   _| | __|   |  \\/  | \\ \\ / /   / __|   /_\\   | \\| | |   \\  \\ \\    / / |_ _|  / __| | || |
| _ \\  \\ V /    | |   | _|    | |\\/| |  \\ V /    \\__ \\  / _ \\  | .` | | |) |  \\ \\/\\/ /   | |  | (__  | __ |
|___/   |_|     |_|   |___|   |_|  |_|   |_|     |___/ /_/ \\_\\ |_|\\_| |___/    \\_/\\_/   |___|  \\___| |_||_|
                                                                                                                 \s """ + ColorCodes.RESET + """
                                                                      
Deli-cious Sandwiches  |  Crafted with Java — Capstone Edition
""");

        UserInterface ui = new UserInterface();
        ui.homeScreen();
    }
}