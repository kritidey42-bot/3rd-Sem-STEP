import java.util.Scanner;

abstract class Student {

    protected String name;

    protected static final double TRANSPORT_FEE = 12000.0;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateTuition();

    public abstract boolean usesBus();

    public double calculateTotalFee() {

        double total = calculateTuition();

        if (usesBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }

    public String getName() {
        return name;
    }
}

class DayScholar extends Student {

    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {

    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000 + 60000;
    }

    @Override
    public boolean usesBus() {
        return false;
    }
}

class ScholarshipStudent extends Student {

    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000;
    }

    @Override
    public boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } 
            else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } 
            else if (type.equals("SCHOLAR")) {
                students[i] =
                    new ScholarshipStudent(name);
            }
        }

        double totalCollected = 0;

        for (Student student : students) {

            double fee = student.calculateTotalFee();

            System.out.printf(
                "%s: %.2f%n",
                student.getName(),
                fee
            );

            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            totalCollected
        );

        sc.close();
    }
}