package com.pluralsight.util;

import com.pluralsight.model.order.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    public static void saveReceiptToFile(Order order) {
        String folderName = "receipts";

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = String.format("%s/%s_%s.txt", folderName, order.getCustomer().getName(), timestamp);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Customer: " + order.getCustomer().getName() + "\n");
            writer.write("Order Summary:\n");

            for (Object item : order.getOrderItems()) {
                writer.write("- " + item.toString() + "\n");
                }
            writer.write(String.format("Total Price: $%.2f\n", order.calculateTotal()));
            writer.write("Total Calories: " + order.getTotalCalories() + " cal\n");
            } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}