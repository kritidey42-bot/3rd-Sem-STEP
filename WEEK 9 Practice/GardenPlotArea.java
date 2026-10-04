import java.util.Scanner;

abstract class Plot {

    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();

    public abstract String getShape();

    public String getOwner() {
        return owner;
    }
}

class Circle extends Plot {

    private double radius;

    public Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {

    private double length;
    private double width;

    public Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {

    private double base;
    private double height;

    public Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotArea {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {

            String shape = sc.next();
            String owner = sc.next();

            if (shape.equals("CIRCLE")) {

                double radius = sc.nextDouble();
                plots[i] = new Circle(owner, radius);

            } else if (shape.equals("RECTANGLE")) {

                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plots[i] = new Rectangle(owner, length, width);

            } else if (shape.equals("TRIANGLE")) {

                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plots[i] = new Triangle(owner, base, height);
            }
        }

        double totalArea = 0;

        for (Plot plot : plots) {

            double area = plot.calculateArea();

            System.out.printf(
                "%s (%s): %.2f%n",
                plot.getOwner(),
                plot.getShape(),
                area
            );

            totalArea += area;
        }

        System.out.printf(
            "Total Area: %.2f%n",
            totalArea
        );

        sc.close();
    }
}
