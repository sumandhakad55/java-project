interface PaymentMethod {

    double SERVICE_TAX_RATE = 0.025;

    void pay(double amount);
}


class CreditCardPayment implements PaymentMethod {

    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {

        double surcharge = amount * SERVICE_TAX_RATE;
        double total = amount + surcharge;

        String lastFour =
            cardNumber.substring(cardNumber.length() - 4);

        String maskedCard = "XXXX-" + lastFour;

        System.out.println(
            "[Credit Card] Transaction Approved for "
            + cardHolderName
            + " (Card: " + maskedCard + ")"
        );

        System.out.println(
            "Base Amount: ₹" + amount
            + " | Surcharge (2.5%): ₹" + surcharge
            + " | Total Debited: ₹" + total
        );
    }
}


class UPIPayment implements PaymentMethod {

    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {

        double surcharge = 0.0;
        double total = amount;

        System.out.println(
            "[UPI Gateway] Transaction Approved for VPA: "
            + upiId
        );

        System.out.println(
            "Base Amount: ₹" + amount
            + " | Surcharge: ₹" + surcharge
            + " | Total Debited: ₹" + total
        );
    }
}


public class PaymentDemo {

    public static void main(String[] args) {

        System.out.println(
            "--- Processing Payments via PaymentMethod Interface ---"
        );

        PaymentMethod[] payments = {
            new CreditCardPayment("1234567894321", "Diya Sen"),
            new UPIPayment("diya@okaxis")
        };

        for (PaymentMethod payment : payments) {
            payment.pay(2000.0);
        }

        /*
        PaymentMethod p = new PaymentMethod();

        Compile-time error:
        PaymentMethod is abstract; cannot be instantiated.
        */
    }
}