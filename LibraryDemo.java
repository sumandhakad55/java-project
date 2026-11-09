class Book {

    private static int totalBooks = 0;

    private final String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;

        totalBooks++;
    }

    public final void display() {
        System.out.println(
            "ISBN: " + isbn +
            " | Title: \"" + title +
            "\" | Author: " + author
        );
    }

    public static int getTotalBooks() {
        return totalBooks;
    }
}


class IssuedBook extends Book {

    private String borrower;
    private int checkoutDuration;

    public static final double DAILY_FINE_RATE = 15.0;

    public IssuedBook(
            String isbn,
            String title,
            String author,
            String borrower,
            int checkoutDuration) {

        super(isbn, title, author);

        this.borrower = borrower;
        this.checkoutDuration = checkoutDuration;
    }

    public void calculateFine(int overdueDays) {

        if (overdueDays > 0) {

            double penalty = overdueDays * DAILY_FINE_RATE;

            System.out.println(
                "Borrower: " + borrower +
                " | Overdue: " + overdueDays +
                " days | Total Penalty: ₹" + penalty
            );

        } else {

            System.out.println(
                "Borrower: " + borrower +
                " | Returned on time. No fine levied."
            );
        }
    }


}


public class LibraryDemo {

    public static void main(String[] args) {

        Book[] library = {
            new Book(
                "978-0134685991",
                "Effective Java",
                "Dhakad"
            ),

            new IssuedBook(
                "978-0596009205",
                "Head First Java",
                "Kathy Sierra",
                "Kajal",
                14
            ),

            new IssuedBook(
                "978-0132350884",
                "Clean Code",
                "Robert C. Martin",
                "Nikk",
                14
            )
        };

        System.out.println("--- Library Catalog Records ---");

        for (Book book : library) {
            book.display();
        }

        System.out.println(
            "Total Cataloged Books in Inventory: " +
            Book.getTotalBooks()
        );

        System.out.println("--- Overdue Penalty Assessments ---");

        ((IssuedBook) library[1]).calculateFine(4);

        ((IssuedBook) library[2]).calculateFine(0);
    }
}