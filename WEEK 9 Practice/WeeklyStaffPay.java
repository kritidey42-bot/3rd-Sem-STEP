import java.util.Scanner;

abstract class StaffMember {

    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class FullTimeStaff extends StaffMember {

    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {

    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {

        if (hours <= 40) {
            return hours * rate;
        } else {
            double regularPay = 40 * rate;
            double overtimePay = (hours - 40) * rate * 1.5;

            return regularPay + overtimePay;
        }
    }
}

class InternStaff extends StaffMember {

    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StaffMember[] staff = new StaffMember[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("FULLTIME")) {

                double salary = sc.nextDouble();
                staff[i] = new FullTimeStaff(name, salary);

            } else if (type.equals("HOURLY")) {

                double hours = sc.nextDouble();
                double rate = sc.nextDouble();

                staff[i] = new HourlyStaff(name, hours, rate);

            } else if (type.equals("INTERN")) {

                double stipend = sc.nextDouble();
                staff[i] = new InternStaff(name, stipend);
            }
        }

        double totalPayroll = 0;

        for (StaffMember member : staff) {

            double pay = member.calculatePay();

            System.out.printf(
                "%s: %.2f%n",
                member.getName(),
                pay
            );

            totalPayroll += pay;
        }

        System.out.printf(
            "Total Payroll: %.2f%n",
            totalPayroll
        );

        sc.close();
    }
}