import java.util.Scanner;

abstract class Delivery {

    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();

    public abstract String getDeliveryType();
}

class StandardDelivery extends Delivery {

    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getDeliveryType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {

    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getDeliveryType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {

    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getDeliveryType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Delivery[] deliveries = new Delivery[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            if (type.equals("STANDARD")) {
                deliveries[i] = new StandardDelivery(weight, distance);
            }
            else if (type.equals("EXPRESS")) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            }
            else if (type.equals("INTERNATIONAL")) {
                double customsFee = sc.nextDouble();

                deliveries[i] = new InternationalDelivery(
                    weight, distance, customsFee
                );
            }
        }

        double total = 0;

        for (Delivery delivery : deliveries) {

            double fee = delivery.calculateFee();

            System.out.printf(
                "%s: %.2f%n",
                delivery.getDeliveryType(),
                fee
            );

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}