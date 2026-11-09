class CoffeeCounter {
    private boolean isCoffeeReady = false;
    private String coffeeName;

    public synchronized void makeCoffee(String name) {
        System.out.println("[Barista] Brewing " + name + "...");

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        coffeeName = name;
        isCoffeeReady = true;

        System.out.println("[Barista] " + coffeeName + " is ready on the counter!");

        notify();
    }

    public synchronized void drinkCoffee() {
        System.out.println("[Customer] Placed order. Waiting at the counter for coffee...");

        while (!isCoffeeReady) {
            try {
                // wait() releases the counter lock temporarily,
                // allowing the barista thread to enter makeCoffee().
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("[Customer] Picked up and enjoying " + coffeeName + "!");

        isCoffeeReady = false;
    }
}

class CustomerThread extends Thread {
    private CoffeeCounter counter;

    CustomerThread(CoffeeCounter counter) {
        this.counter = counter;
    }

    public void run() {
        counter.drinkCoffee();
    }
}

class BaristaThread extends Thread {
    private CoffeeCounter counter;

    BaristaThread(CoffeeCounter counter) {
        this.counter = counter;
    }

    public void run() {
        counter.makeCoffee("Caramel Frappuccino");
    }
}

public class CoffeeShopDemo {
    public static void main(String[] args) throws InterruptedException {

        CoffeeCounter counter = new CoffeeCounter();

        CustomerThread customer = new CustomerThread(counter);
        BaristaThread barista = new BaristaThread(counter);

        System.out.println("--- Campus Cafe Opened ---");

        customer.start();
        barista.start();

        customer.join();
        barista.join();

        System.out.println("--- Cafe Closed for the Day ---");
    }
}