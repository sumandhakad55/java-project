class DigitalWallet {
    private int balance = 800;

    public synchronized void makePayment(String user, int amount) {

        if (balance >= amount) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            balance = balance - amount;

            System.out.println("[" + user + "] Paid ₹" + amount
                    + " for groceries. Remaining Balance: ₹" + balance);

        } else {

            System.out.println("[" + user + "] Payment of ₹" + amount
                    + " DECLINED! Insufficient balance (Only ₹"
                    + balance + " left).");
        }
    }

    public int getBalance() {
        return balance;
    }
}

class Roommate implements Runnable {

    private DigitalWallet wallet;
    private String name;
    private int amount;

    Roommate(DigitalWallet wallet, String name, int amount) {
        this.wallet = wallet;
        this.name = name;
        this.amount = amount;
    }

    public void run() {
        wallet.makePayment(name, amount);
    }
}

public class EWalletDemo {

    public static void main(String[] args) throws InterruptedException {

        DigitalWallet wallet = new DigitalWallet();

        Thread amit = new Thread(
                new Roommate(wallet, "Amit-Thread", 500));

        Thread rahul = new Thread(
                new Roommate(wallet, "Rahul-Thread", 500));

        System.out.println(
                "--- Roommate Shared E-Wallet Initialized (Balance: ₹800) ---");

        amit.start();
        rahul.start();

        System.out.println(
                "[CHECK] Amit-Thread is active: " + amit.isAlive()
                + " | Rahul-Thread is active: " + rahul.isAlive());

        amit.join();
        rahul.join();

        System.out.println(
                "[CHECK] Amit-Thread is active: " + amit.isAlive()
                + " | Rahul-Thread is active: " + rahul.isAlive());

        System.out.println("--- Final Wallet Summary ---");
        System.out.println("Verified Final Balance: ₹" + wallet.getBalance());
        System.out.println("All transactions settled successfully.");
    }
}