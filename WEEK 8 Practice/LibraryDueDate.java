import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {

    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getLoanDays();

    public String getTitle() {
        return title;
    }

    public LocalDate calculateDueDate() {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        return currentDate.plusDays(getLoanDays());
    }
}

class Book extends LibraryItem {

    public Book(String title) {
        super(title);
    }

    @Override
    public int getLoanDays() {
        return 14;
    }
}

class DVD extends LibraryItem {

    public DVD(String title) {
        super(title);
    }

    @Override
    public int getLoanDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {

    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getLoanDays() {
        return 3;
    }
}

public class LibraryDueDate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1);

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } 
            else if (type.equals("DVD")) {
                items[i] = new DVD(title);
            } 
            else if (type.equals("MAGAZINE")) {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {

            System.out.println(
                item.getTitle() + ": " + item.calculateDueDate()
            );
        }

        sc.close();
    }
}
