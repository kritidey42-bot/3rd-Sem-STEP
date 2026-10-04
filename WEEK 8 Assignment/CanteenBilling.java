import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public abstract String getCustomerType();
}

class Student extends Customer {

    public Student(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }
}

class Staff extends Customer {

    public Staff(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }
}

class Guest extends Customer {

    public Guest(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10;
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }
}

public class CanteenBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("STUDENT")) {
                customers[i] = new Student(amount);
            }
            else if (type.equals("STAFF")) {
                customers[i] = new Staff(amount);
            }
            else if (type.equals("GUEST")) {
                customers[i] = new Guest(amount);
            }
        }

        double total = 0;

        for (Customer customer : customers) {

            double finalAmount = customer.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                customer.getCustomerType(),
                finalAmount
            );

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}