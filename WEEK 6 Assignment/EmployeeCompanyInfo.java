public class EmployeeCompanyInfo {

    static class Employee {

        String empName;
        double salary;

        static String companyName =
            "Bright Horizon Technologies";

        static int employeeCount = 0;

        Employee(String empName, double salary) {

            this.empName = empName;
            this.salary = salary;

            employeeCount++;
        }
    }

    static void printCompanyInfo() {

        System.out.println(Employee.companyName);
        System.out.println(
            "Employees on record: "
            + Employee.employeeCount
        );
    }

    public static void main(String[] args) {

        new Employee("Divya", 65000);
        new Employee("Arjun", 30000);
        new Employee("Ravi", 50000);

        EmployeeCompanyInfo.printCompanyInfo();
    }
}
