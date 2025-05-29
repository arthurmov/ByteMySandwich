package com.pluralsight.model.order;

import com.pluralsight.model.food.Chips;
import com.pluralsight.model.food.Drink;
import com.pluralsight.model.customer.Customer;
import com.pluralsight.model.food.Sandwich;
import com.pluralsight.model.interfaces.Caloric;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Object> orderItems;
    private double totalPrice;
    private int orderNumber;
    private Customer customer;

    public Order(Customer customer) {
        this.orderItems = new ArrayList<>();
        this.totalPrice = 0.00;
        LocalDateTime timestamp = LocalDateTime.now();
        this.customer = customer;
        this.orderNumber = getOrderNumber();
    }

    public List<Object> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Object> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addSandwich(Sandwich sandwich) {
        orderItems.add(sandwich);
        totalPrice += sandwich.getValue();
    }

    public void addDrink(Drink drink) {
        orderItems.add(drink);
        totalPrice += drink.getValue();
    }

    public void addChips(Chips chips) {
        orderItems.add(chips);
        totalPrice += chips.getValue();
    }

    public double calculateTotal() {
        return totalPrice;
    }

    public void generateReceipt() {

    }

    public int getTotalCalories() {
        int totalCalories = 0;
        for (Object item : orderItems) {
            if (item instanceof Caloric caloricItem) {
                totalCalories += caloricItem.getCalories();
            }
        }
        return totalCalories;
    }
}
