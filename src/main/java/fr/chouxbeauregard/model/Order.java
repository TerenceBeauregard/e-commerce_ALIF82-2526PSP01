package fr.chouxbeauregard.model;

import java.io.Serializable;

public class Order implements Serializable {

    private String orderId;
    private String customer;
    private double amount;

    public Order(String orderId, String customer, double amount) {
        this.orderId = orderId;
        this.customer = customer;
        this.amount = amount;
    }

    public String toString() {
        return "Order[ID=" + orderId + ", Client=" + customer + ", Montant=" + amount + "]";
    }
}
