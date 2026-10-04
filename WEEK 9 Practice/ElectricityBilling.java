import java.util.Scanner;

abstract class ElectricityConnection {

    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class HomeConnection extends ElectricityConnection {

    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {

        if (units <= 100) {
            return units * 5;
        } else {
            return (100 * 5) + ((units - 100) * 7);
        }
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {

    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8) + 100;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {

    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(units * 6, 1000);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class ElectricityBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ElectricityConnection[] connections =
            new ElectricityConnection[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            if (type.equals("HOME")) {

                connections[i] = new HomeConnection(units);

            } else if (type.equals("SHOP")) {

                connections[i] = new ShopConnection(units);

            } else if (type.equals("FACTORY")) {

                connections[i] = new FactoryConnection(units);
            }
        }

        double total = 0;

        for (ElectricityConnection connection : connections) {

            double bill = connection.calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                connection.getType(),
                bill
            );

            total += bill;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}