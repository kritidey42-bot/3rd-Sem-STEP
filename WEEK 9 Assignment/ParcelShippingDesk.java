import java.util.Scanner;

abstract class Parcel {

    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();

    public abstract double calculateInsurance();

    public abstract String getType();

    public double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel {

    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40 + (10 * weight);
    }

    @Override
    public double calculateInsurance() {
        return 0;
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel {

    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80 + (15 * weight);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel {

    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    public String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            if (type.equals("STANDARD")) {
                parcels[i] =
                    new StandardParcel(weight, declaredValue);
            } 
            else if (type.equals("EXPRESS")) {
                parcels[i] =
                    new ExpressParcel(weight, declaredValue);
            } 
            else if (type.equals("FRAGILE")) {
                parcels[i] =
                    new FragileParcel(weight, declaredValue);
            }
        }

        double grandTotal = 0;

        for (Parcel parcel : parcels) {

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                parcel.getType(),
                charge,
                insurance,
                total
            );

            grandTotal += total;
        }

        System.out.printf(
            "Grand Total: %.2f%n",
            grandTotal
        );

        sc.close();
    }
}