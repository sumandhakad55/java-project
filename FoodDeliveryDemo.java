class FoodOrder {

    private String dishName;
    private boolean isDelivered = false;

    public synchronized void receiveOrder() {

        System.out.println(
                "[Student-Thread] Order placed! Waiting at the hostel gate...");

        while (!isDelivered) {
            try {
                // wait() releases the lock temporarily.
                // Therefore, Rider-Thread can enter deliverOrder()
                // and deliver the food.
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "[Student-Thread] Parcel collected! Enjoying "
                + dishName + ".");

        isDelivered = false;
    }

    public synchronized void deliverOrder(String dish) {

        System.out.println(
                "[Rider-Thread] Driving to location with '" + dish + "'...");

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        dishName = dish;
        isDelivered = true;

        System.out.println(
                "[Rider-Thread] Arrived at hostel gate. Ringing bell via notify()!");

        notify();
    }
}

public class FoodDeliveryDemo {

    public static void main(String[] args) throws InterruptedException {

        FoodOrder order = new FoodOrder();

        Thread student = new Thread(() -> {
            order.receiveOrder();
        }, "Student-Thread");

        Thread rider = new Thread(() -> {
            order.deliverOrder("Paneer Butter Masala & Naan");
        }, "Rider-Thread");

        System.out.println(
                "--- Food Delivery App: Order #FD-402 Placed ---");

        student.start();

        Thread.sleep(50);

        System.out.println(
                "[APP TRACKER] Rider is on the way: isAlive() = "
                + rider.isAlive());

        rider.start();

        rider.join();
        student.join();

        System.out.println(
                "[APP TRACKER] Rider confirmed delivered: isAlive() = "
                + rider.isAlive());

        System.out.println(
                "--- Order Completed & App Closed Successfully ---");
    }
}