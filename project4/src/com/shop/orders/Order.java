package com.shop.orders;

public abstract class Order {

    private static int sequenceCounter = 1001;

    protected int orderId;
    protected String customerName;
    protected double basePrice;

    public Order(String customerName, double basePrice) {
        this.orderId = sequenceCounter++;
        this.customerName = customerName;
        this.basePrice = basePrice;
    }

    public final void displayOrderSummary() {
        System.out.println(
            "Order ID: #" + orderId +
            " | Customer: " + customerName +
            " | Base Price: ₹" + basePrice
        );
    }
}