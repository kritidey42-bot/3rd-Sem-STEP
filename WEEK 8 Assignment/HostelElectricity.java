import java.util.Scanner;

abstract class Room {

    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getRoomType();
}

class SingleRoom extends Room {

    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8;
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {

    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6) / (double) occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }
}

class ACRoom extends Room {

    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10) + 200;
    }

    @Override
    public String getRoomType() {
        return "AC";
    }
}

public class HostelElectricity {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            }
            else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            }
            else if (type.equals("AC")) {
                rooms[i] = new ACRoom(units);
            }
        }

        double total = 0;

        for (Room room : rooms) {

            double bill = room.calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                room.getRoomType(),
                bill
            );

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
