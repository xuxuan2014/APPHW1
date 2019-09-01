import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    static Map<String, Book> book = new HashMap<>();
    static Map<String, Borrower> borrower = new HashMap<>();

    public static void main(String[] args){
        putBooks();
        putBorrowers();
        boolean exit = false;
        Scanner userInput = new Scanner(System.in);

        while (true) {
            // let the user choose the command
            System.out.println("Please enter a command: 1. Check out a book, 2. Return a book, 3. Exit");
            String userCommand = userInput.nextLine();
            switch (userCommand) {
                case "1": {
                    Info info = enterInfo();
                    Book newBook = book.get(info.bookId);
                    Borrower newBorrower = borrower.get(info.borrowerId);
                    if (newBook.available == false) {
                        System.out.println(info.bookId +" already checked out");
                    } else {
                        System.out.println("checkout successful");
                        newBorrower.book.add(info.bookId);
                        newBook.available = false;
                    }
                    break;
                }
                case "2": {
                    Info info = enterInfo();
                    Book newBook = book.get(info.bookId);
                    Borrower newBorrower = borrower.get(info.borrowerId);
                    if (!newBorrower.book.contains(info.bookId)) {
                        System.out.println(info.bookId + " not currently checked out");
                    } else {
                        System.out.println("return successful");
                        newBorrower.book.remove(info.bookId);
                        newBook.available = true;
                    }
                    break;
                }
                case "3": {
                    exit = true;
                    break;
                }
            }
            if (exit == true) break;
        }
    }

    static class Info {
        public String borrowerId;
        public String bookId;
        public Info(){};
    };

    public static Info enterInfo() {
        Info result = new Info();
        Scanner userInput = new Scanner(System.in);
        // let the user enter his/her username
        System.out.println("Please enter borrower id");
        String borrowerID = userInput.nextLine();
        if (!borrower.containsKey(borrowerID))
            System.out.println(borrowerID + " is not a valid borrower");
        result.borrowerId = borrowerID;

        // let the user enter the book id
        System.out.println("Please enter the book id");
        String bookID = userInput.nextLine();
        if (!book.containsKey(bookID))
            System.out.println("there is no such book " + bookID);
        result.bookId = bookID;

        return result;
    }

    public static void putBooks() {
        Book a1 = new Book();
        Book a2 = new Book();
        Book a3 = new Book();
        Book a4 = new Book();
        Book a5 = new Book();
        Book a6 = new Book();
        Book a7 = new Book();
        Book a8 = new Book();
        Book a9 = new Book();
        Book a10 = new Book();
        book.put("a1", a1);
        book.put("a2", a2);
        book.put("a3", a3);
        book.put("a4", a4);
        book.put("a5", a5);
        book.put("a6", a6);
        book.put("a7", a7);
        book.put("a8", a8);
        book.put("a9", a9);
        book.put("a10", a10);
    }

    public static void putBorrowers() {
        Borrower b1 = new Borrower();
        Borrower b2 = new Borrower();
        Borrower b3 = new Borrower();
        Borrower b4 = new Borrower();
        Borrower b5 = new Borrower();
        borrower.put("b1", b1);
        borrower.put("b2", b2);
        borrower.put("b3", b3);
        borrower.put("b4", b4);
        borrower.put("b5", b5);
    }

}
