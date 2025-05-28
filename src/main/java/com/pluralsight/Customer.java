package com.pluralsight;

import java.util.List;

public class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        
    }
}
