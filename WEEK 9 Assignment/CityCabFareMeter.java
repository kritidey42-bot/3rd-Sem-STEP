import java.util.Scanner;

abstract class Cab {

    protected double distance;

    protected static final double MINIMUM_FARE = 100.0;

    public Cab(double distance) {
        this.distance = distance;
    }

    public abstract double getRate();

    public abstract String getType();

    public abstract boolean supportsNightService();

    public double calculateFare() {

        double fare = distance * getRate();

        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }

        return fare;
    }
}

class MiniCab extends Cab {

    public MiniCab(double distance) {
        super(distance);
    }

    @Override
    public double getRate() {
        return 10;
    }

    @Override
    public String getType() {
        return "MINI";
    }

    @Override
    public boolean supportsNightService() {
        return false;
    }
}

class SedanCab extends Cab {

    public SedanCab(double distance) {
        super(distance);
    }

    @Override
    public double getRate() {
        return 14;
    }

    @Override
    public String getType() {
        return "SEDAN";
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

class SUVCab extends Cab {

    public SUVCab(double distance) {
        super(distance);
    }

    @Override
    public double getRate() {
        return 18;
    }

    @Override
    public String getType() {
        return "SUV";
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            times[i] = time;

            if (type.equals("MINI")) {
                cabs[i] = new MiniCab(km);
            } 
            else if (type.equals("SEDAN")) {
                cabs[i] = new SedanCab(km);
            } 
            else if (type.equals("SUV")) {
                cabs[i] = new SUVCab(km);
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {

            Cab cab = cabs[i];

            if (times[i].equals("NIGHT")
                    && !cab.supportsNightService()) {

                System.out.println(
                    cab.getType() +
                    ": night service not available"
                );

                continue;
            }

            double fare = cab.calculateFare();

            if (times[i].equals("NIGHT")) {
                fare = fare * 1.20;
            }

            System.out.printf(
                "%s: %.2f%n",
                cab.getType(),
                fare
            );

            total += fare;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );

        sc.close();
    }
}