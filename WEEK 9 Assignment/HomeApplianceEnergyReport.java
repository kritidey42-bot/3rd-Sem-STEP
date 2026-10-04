import java.util.Scanner;

abstract class Appliance {

    protected double hours;

    protected static final double COST_PER_UNIT = 8.0;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPower();

    public abstract String getType();

    public abstract boolean supportsSaverMode();

    public double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    public double calculateCost() {
        return calculateUnits() * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {

    public Fridge(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 150;
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }

    @Override
    public boolean supportsSaverMode() {
        return false;
    }
}

class AirConditioner extends Appliance {

    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 1500;
    }

    @Override
    public String getType() {
        return "AC";
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

class Television extends Appliance {

    public Television(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 100;
    }

    @Override
    public String getType() {
        return "TV";
    }

    @Override
    public boolean supportsSaverMode() {
        return false;
    }
}

class WashingMachine extends Appliance {

    public WashingMachine(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 500;
    }

    @Override
    public String getType() {
        return "WASHER";
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        boolean[] saverMode = new boolean[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            String mode = "";

            if (sc.hasNext("SAVER")) {
                mode = sc.next();
            }

            saverMode[i] = mode.equals("SAVER");

            if (type.equals("FRIDGE")) {
                appliances[i] = new Fridge(hours);
            } 
            else if (type.equals("AC")) {
                appliances[i] =
                    new AirConditioner(hours);
            } 
            else if (type.equals("TV")) {
                appliances[i] =
                    new Television(hours);
            } 
            else if (type.equals("WASHER")) {
                appliances[i] =
                    new WashingMachine(hours);
            }
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            Appliance appliance = appliances[i];

            if (saverMode[i]
                    && !appliance.supportsSaverMode()) {

                System.out.println(
                    appliance.getType() +
                    ": saver mode not supported"
                );

                continue;
            }

            double units = appliance.calculateUnits();

            if (saverMode[i]) {
                units = units * 0.75;
            }

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.getType(),
                units,
                cost
            );

            totalCost += cost;
        }

        System.out.printf(
            "Total Cost: %.2f%n",
            totalCost
        );

        sc.close();
    }
}