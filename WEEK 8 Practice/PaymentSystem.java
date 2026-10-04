import java.util.Scanner;

abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public abstract String getPaymentType();
}

class CardPayment extends Payment {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {

    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {

    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }

    @Override
    public String getPaymentType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Payment[] payments = new Payment[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } 
            else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } 
            else if (type.equals("BANKTRANSFER")) {
                payments[i] = new BankTransferPayment(amount);
            }
        }

        double total = 0;

        for (Payment payment : payments) {

            double finalAmount = payment.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                payment.getPaymentType(),
                finalAmount
            );

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
