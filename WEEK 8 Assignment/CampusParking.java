import java.util.Scanner;

abstract class Vehicle {

    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();

    public abstract String getVehicleType();
}

class Bike extends Vehicle {

    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10;
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }
}

class Car extends Vehicle {

    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }
}

class Truck extends Vehicle {

    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }
}

public class CampusParking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            }
            else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            }
            else if (type.equals("TRUCK")) {
                vehicles[i] = new Truck(hours);
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles) {

            double charge = vehicle.calculateCharge();

            System.out.printf(
                "%s: %.2f%n",
                vehicle.getVehicleType(),
                charge
            );

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
