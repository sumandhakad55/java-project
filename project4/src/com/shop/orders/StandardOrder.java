package com.shop.orders;

import com.shop.contracts.Payable;
import com.shop.contracts.Trackable;

public class StandardOrder extends Order
        implements Payable, Trackable {

    private String deliveryAddress;
    private double shippingFee;

    public StandardOrder(
            String customerName,
            double basePrice,
            String deliveryAddress,
            double shippingFee) {

        super(customerName, basePrice);

        this.deliveryAddress = deliveryAddress;
        this.shippingFee = shippingFee;
    }

    @Override
    public double calculateTotalAmount() {

        double gst = basePrice * GST_PERCENT / 100;

        return basePrice + shippingFee + gst;
    }

    @Override
    public void trackShipment() {

        System.out.println(
            "[Logistics Dispatch] Tracking ID: TRK-"
            + orderId + "-IN "
            + "Package for " + customerName
            + " dispatched to: '" + deliveryAddress
            + "' | Status: In Transit"
        );
    }

    public double getShippingFee() {
        return shippingFee;
    }
}