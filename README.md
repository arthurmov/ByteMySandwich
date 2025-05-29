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

### 🧩 UML Class Diagram

---

### 📸 Screenshots

---

### 🧠 Interesting Piece of Code
```java
@Override
public String getDescription() {
    StringBuilder desc = new StringBuilder();

    // Basic sandwich header
    desc.append(size.getName()).append(" ")
        .append(bread.getMenuName()).append(" sandwich");
    desc.append(isToasted ? " (Toasted)" : " (Not Toasted)");

    // Separate meats and cheeses
    List<String> meats = new ArrayList<>();
    List<String> cheeses = new ArrayList<>();

    for (PremiumTopping pt : meatsAndCheeses) {
        String name = pt.getName().toLowerCase();
        if (Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon").contains(name)) {
            meats.add(pt.getMenuName());
        } else {
            cheeses.add(pt.getMenuName());
        }
    }

    if (!meats.isEmpty()) desc.append(" | Meats: ").append(String.join(", ", meats));
    if (!cheeses.isEmpty()) desc.append(" | Cheeses: ").append(String.join(", ", cheeses));

    // Regular toppings
    if (!toppings.isEmpty()) {
        List<String> regulars = toppings.stream()
                                        .map(Topping::getMenuName)
                                        .toList();
        desc.append(" | Toppings: ").append(String.join(", ", regulars));
    }

    if (sauce != null) {
        desc.append(" | Sauce: ").append(sauce.getMenuName());
    }

    // Price and calorie count
    desc.append(" | $").append(String.format("%.2f", getValue()));
    desc.append(" | ").append(getCalories()).append(" cal");

    return desc.toString();
}

```

This **getDescription()** method is a great example of thoughtful, user-facing logic combined with clean, object-oriented design. It dynamically assembles a clear, readable summary of a sandwich based on the customer's selections, including bread type, size, toast preference, meats, cheeses, toppings, sauce, total price, and calories. The method smartly distinguishes between meats and cheeses by filtering premium toppings based on name, and uses modern Java techniques like StringBuilder, List<String>, and stream mapping for efficiency and clarity. It reflects the real-world needs of a deli-style point-of-sale system while keeping the code modular, readable, and easy to extend. This method is a perfect showcase of how backend data can be translated into a polished customer-facing experience.

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