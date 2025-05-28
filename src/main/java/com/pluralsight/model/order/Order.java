package com.pluralsight.model.order;

import com.pluralsight.model.food.Chips;
import com.pluralsight.model.food.Drink;
import com.pluralsight.model.customer.Customer;
import com.pluralsight.model.food.Sandwich;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Object> orderItems;
    private double totalPrice;
    private int orderNumber;
    private LocalDateTime timestamp;
    private Customer customer;

    public Order(Customer customer) {
        this.orderItems = new ArrayList<>();
        this.totalPrice = 0.0;
        this.timestamp = LocalDateTime.now();
        this.customer = customer;
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

    }

    public void addDrink(Drink drink) {

    }

    public void addChips(Chips chips) {

    }

    public double calculateTotal() {
        return 0;
    }

    public void generateReceipt() {

    }

    public int getTotalCalories() {
        return 0;
    }
}
