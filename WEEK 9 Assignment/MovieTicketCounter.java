import java.util.Scanner;

abstract class Ticket {

    protected int count;

    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getPrice();

    public double getAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }

    public abstract String getSeatType();
}

class RegularTicket extends Ticket {

    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getPrice() {
        return 150.0;
    }

    @Override
    public String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {

    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getPrice() {
        return 250.0;
    }

    @Override
    public String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {

    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getPrice() {
        return 400.0;
    }

    @Override
    public String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {

            String seat = sc.next();
            int count = sc.nextInt();

            if (seat.equals("REGULAR")) {
                tickets[i] = new RegularTicket(count);
            } 
            else if (seat.equals("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);
            } 
            else if (seat.equals("RECLINER")) {
                tickets[i] = new ReclinerTicket(count);
            }
        }

        double total = 0;

        for (Ticket ticket : tickets) {

            double amount = ticket.getAmount();

            System.out.printf(
                "%s: %.2f%n",
                ticket.getSeatType(),
                amount
            );

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}