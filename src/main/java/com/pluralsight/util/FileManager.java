package com.pluralsight.util;

import com.pluralsight.model.interfaces.Caloric;
import com.pluralsight.model.interfaces.Priceable;
import com.pluralsight.model.order.Order;
import com.pluralsight.model.interfaces.MenuItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class FileManager {

    public static void saveReceiptToFile(Order order) {
        String folderPath = "receipts";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String timestamp = order.getTimestamp().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = folderPath + "/" + order.getCustomer().getName() + "_" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("======= Byte My Sandwich =======\n");
            writer.write("Customer: " + order.getCustomer().getName() + "\n");
            writer.write("Order #: " + order.generateOrderNumber() + "\n");
            writer.write("Date: " + order.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("================================\n");

            for (Object item : order.getOrderItems()) {
                if (item instanceof MenuItem menuItem) {
                    writer.write("- " + menuItem.getDescription() + "\n");

                    if (item instanceof Priceable priceable && item instanceof Caloric caloric) {
                        writer.write(String.format("  $%.2f | %d cal\n", priceable.getValue(), caloric.getCalories()));
                    } else {
                        writer.write("  [No price/calorie info available]\n");
                    }
                }
            }

            writer.write("================================\n");
            writer.write(String.format("Total: $%.2f\n", order.calculateTotal()));
            writer.write("Total Calories: " + order.getTotalCalories() + " cal\n");
            writer.write("Thank you for dining with us!\n");

            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}
