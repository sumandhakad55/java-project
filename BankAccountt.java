class BankAccount {

    protected String accountNumber;
    protected double balance;

    public static final double MINIMUM_BALANCE = 1000.0;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double computeTransactionFee(double amount) {
        return 20.0;
    }

    public final void processWithdrawal(double amount) {

        double fee = computeTransactionFee(amount);
        double totalDebit = amount + fee;

        System.out.println("Processing withdrawal for: " + accountNumber);
        System.out.println("Requested Amount: ₹" + amount + " | Computed Fee: ₹" + fee);

        if (balance - totalDebit < MINIMUM_BALANCE) {
            System.out.println(
                "Status: Transaction Denied. Remaining balance would breach MINIMUM_BALANCE"
            );
            System.out.println();
        } else {
            balance -= totalDebit;

            System.out.println(
                "Status: Transaction Approved. Total Debited: ₹" + totalDebit +
                " | Remaining Balance: ₹" + balance
            );
            System.out.println();
        }
    }
}


class PremiumAccount extends BankAccount {

    public PremiumAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double computeTransactionFee(double amount) {
        return 0.0;
    }
}


class InternationalAccount extends BankAccount {

    public InternationalAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double computeTransactionFee(double amount) {
        return 0.035 * amount;
    }
}


final class BlockedAccount extends BankAccount {

    public BlockedAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    
}


public class BankAccountt {

    public static void main(String[] args) {

        BankAccount[] accounts = {
            new BankAccount("STD-1001", 5000.0),
            new PremiumAccount("PREM-2002", 5000.0),
            new InternationalAccount("INTL-3003", 5000.0)
        };

        for (BankAccount account : accounts) {
            account.processWithdrawal(3900.0);
        }
    }
}