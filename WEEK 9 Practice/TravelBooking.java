import java.util.Scanner;

abstract class Booking {

    protected double distance;

    protected static final double BOOKING_FEE = 50.0;

    public Booking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateBaseFare();

    public abstract String getMode();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {

    public BusBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return distance * 2;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {

    public TrainBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return distance * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {

    public FlightBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return 2500 + distance * 4;
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class TravelBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equals("BUS")) {
                bookings[i] = new BusBooking(distance);
            } 
            else if (mode.equals("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } 
            else if (mode.equals("FLIGHT")) {
                bookings[i] = new FlightBooking(distance);
            }
        }

        for (Booking booking : bookings) {

            System.out.printf(
                "%s: %.2f%n",
                booking.getMode(),
                booking.calculateTotal()
            );
        }

        sc.close();
    }
}