# Byte My Sandwich – Java CLI Ordering System

Welcome to **Byte My Sandwich**, the CLI-based ordering system for our custom sandwich shop, built as part of the DELI-cious Java OOP Capstone. This Java project simulates a real-world point-of-sale application that lets customers build sandwiches, add sides, and generate detailed receipts—all from the terminal.

---

### 🥪 Overview

Byte My Sandwich lets users fully customize their orders by selecting bread types, sandwich sizes, toppings (regular and premium), sauces, drinks, and chips. Orders are confirmed in-app and written to timestamped receipt files for record-keeping.

The project emphasizes **Object-Oriented Programming** (OOP) using inheritance, encapsulation, abstraction, and clean code practices.

---

### 🚀 Features

- Build-your-own sandwich: size, bread, toppings, sauces, and toasting
- Premium toppings (meats, cheeses) with size-based pricing
- Add sides: chips and drinks in multiple sizes
- Dynamic order summary with total cost and calories
- Save receipts as `.txt` files using timestamped filenames
- Bonus: Signature sandwiches like BLT and Philly Cheesesteak
- Bonus: Calorie Tracker – shows total calories per item and full order for nutrition-aware customers

---

### 📸 Screenshots

---

### 🧠 Interesting Piece of Code

---

### 📁 Project Structure

```bash
ByteMySandwich/
├── images/                             # Screenshots
├── receipts/                           # Output receipts (.txt files)
└── src/
    └── main/
        └── java/
            └── com/
                └── pluralsight/
                    ├── model/
                    │   ├── order/
                    │   │   └── Order.java
                    │   ├── food/
                    │   │   ├── components/
                    │   │   │   ├── Bread.java
                    │   │   │   ├── Sauce.java
                    │   │   │   └── Size.java
                    │   │   ├── signature/
                    │   │   │   ├── BLT.java
                    │   │   │   └── PhillyCheeseSteak.java
                    │   │   ├── toppings/
                    │   │   │   ├── PremiumTopping.java
                    │   │   │   ├── RegularTopping.java
                    │   │   │   └── Topping.java
                    │   │   ├── Chips.java
                    │   │   ├── Drink.java
                    │   │   └── Sandwich.java
                    │   ├── customer/
                    │   │   └── Customer.java
                    │   └── interfaces/
                    │       ├── Caloric.java
                    │       ├── Flavored.java
                    │       ├── MenuItem.java
                    │       ├── Priceable.java
                    │       └── Sizeable.java
                    ├── ui/
                    │   ├── Program.java
                    │   └── UserInterface.java
                    └── util/
                        ├── ColorCodes.java
                        ├── Console.java
                        └── FileManager.java