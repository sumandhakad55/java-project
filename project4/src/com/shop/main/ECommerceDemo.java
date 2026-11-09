package project4.shop.main;

import com.shop.contracts.Payable;
import com.shop.contracts.Trackable;
import com.shop.orders.StandardOrder;

public class ECommerceDemo {

    public static void main(String[] args) {

        System.out.println("--- Order Billing Settlement ---");

        StandardOrder order1 = new StandardOrder(
            "Priya Nair",
            4500.0,
            "Flat 402, MG Road, Bengaluru",
            150.0
        );

        StandardOrder order2 = new StandardOrder(
            "Amit Kumar",
            1200.0,
            "Sector 15, Noida",
            80.0
        );

        Payable[] orders = {
            order1,
            order2
        };

        for (Payable order : orders) {

            StandardOrder current =
                (StandardOrder) order;

            current.displayOrderSummary();

            System.out.println(
                "Net Payable (Base + ₹"
                + current.getShippingFee()
                + " Shipping + 18% GST): ₹"
                + current.calculateTotalAmount()
            );
        }

        System.out.println();
        System.out.println("--- Logistics & Shipment Tracking ---");

        if (order1 instanceof Trackable) {

            Trackable tracking =
                (Trackable) order1;

            tracking.trackShipment();
        }
    }
}
/*
cd ShopProject
javac -d out src\com\shop\contracts\Payable.java src\com\shop\contracts\Trackable.java src\com\shop\orders\Order.java src\com\shop\orders\StandardOrder.java src\com\shop\main\ECommerceDemo.java
java -cp out com.shop.main.ECommerceDemo
 */