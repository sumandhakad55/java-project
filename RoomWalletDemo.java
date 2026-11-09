class RoomWallet {

    private int balance = 1000;

    public synchronized boolean debit(String studentName, int amount) {

        if (balance < amount) {
            System.out.println("[TX REJECTED] " + studentName
                    + ": Insufficient funds! Current Balance: ₹"
                    + balance + " | Required: ₹" + amount);
            return false;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[TX CANCELLED] " + studentName
                    + ": Transaction interrupted.");
            return false;
        }

        balance -= amount;

        System.out.println("[TX SUCCESS] " + studentName
                + " debited ₹" + amount
                + " | Remaining Balance: ₹" + balance);

        return true;
    }

    public synchronized int getBalance() {
        return balance;
    }
}

public class RoomWalletDemo {

    public static void main(String[] args) throws InterruptedException {

        RoomWallet wallet = new RoomWallet();

        System.out.println(
                "[SYSTEM] Joint Room Wallet Initialized: ₹"
                + wallet.getBalance());

        Runnable roommate1 = () -> {
            System.out.println(
                    "[TX START] Roommate 1 attempting to debit ₹700...");
            wallet.debit("Roommate 1", 700);
        };

        Runnable roommate2 = () -> {
            System.out.println(
                    "[TX START] Roommate 2 attempting to debit ₹700...");
            wallet.debit("Roommate 2", 700);
        };

        Thread t1 = new Thread(roommate1);
        Thread t2 = new Thread(roommate2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("======================================================");
        System.out.println(
                "[AUDIT] All transactions settled. Final Reconciled Balance: ₹"
                + wallet.getBalance());
    }
}