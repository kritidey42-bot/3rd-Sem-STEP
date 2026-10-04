import java.util.Scanner;

abstract class Transport {

    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();

    public abstract String getTransportType();
}

class Bus extends Transport {

    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }
}

class Train extends Transport {

    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }
}

class Metro extends Transport {

    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        double baseFare = 1.50 + (0.20 * distance);
        return baseFare * peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }
}

public class PublicTransportFare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Transport[] transports = new Transport[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double distance = sc.nextDouble();

            if (type.equals("BUS")) {
                transports[i] = new Bus(distance);
            }
            else if (type.equals("TRAIN")) {
                transports[i] = new Train(distance);
            }
            else if (type.equals("METRO")) {

                double peakHourFactor = sc.nextDouble();

                transports[i] = new Metro(
                    distance,
                    peakHourFactor
                );
            }
        }

        double total = 0;

        for (Transport transport : transports) {

            double fare = transport.calculateFare();

            System.out.printf(
                "%s: %.2f%n",
                transport.getTransportType(),
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