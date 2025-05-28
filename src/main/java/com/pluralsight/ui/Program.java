package com.pluralsight.ui;

import com.pluralsight.util.ColorCodes;

public class Program {
    public static void main(String[] args) {

        System.out.println(ColorCodes.RED + """
                 \s
 ___  __   __  _____   ___     __  __  __   __    ___     _     _  _   ___   __      __  ___    ___   _  _\s
| _ ) \\ \\ / / |_   _| | __|   |  \\/  | \\ \\ / /   / __|   /_\\   | \\| | |   \\  \\ \\    / / |_ _|  / __| | || |
| _ \\  \\ V /    | |   | _|    | |\\/| |  \\ V /    \\__ \\  / _ \\  | .` | | |) |  \\ \\/\\/ /   | |  | (__  | __ |
|___/   |_|     |_|   |___|   |_|  |_|   |_|     |___/ /_/ \\_\\ |_|\\_| |___/    \\_/\\_/   |___|  \\___| |_||_|
""" + ColorCodes.BRIGHT_YELLOW + """
                                                                                             \s
         Deli-cious Sandwiches\s""" + ColorCodes.RED + "|" + ColorCodes.BRIGHT_YELLOW + " Crafted with Java — Capstone Edition" + ColorCodes.RESET);


        UserInterface ui = new UserInterface();
        ui.homeScreen();
    }
}