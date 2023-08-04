import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
    // First library book collection
    public ArrayList<Book> libraryBookCollection = new ArrayList<>();
    public String address;
    public static final String HOURS_OF_OPERATION = "9am to 5pm";


    // Constructor
    public Library(String address) {
        this.address = address;
    }

    //Add new books to library collection
    public void addBook(Book newBook) {
        libraryBookCollection.add(newBook);
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from " + HOURS_OF_OPERATION);
    }

    public void printAddress() {
        System.out.println(address);
    }

    public void borrowBook(String bookTitle) {

        for(Book book : libraryBookCollection) {
            if(book.title.equalsIgnoreCase(bookTitle)) {
                if(!book.isBorrowed()) {
                    book.borrowed();
                    System.out.println("You successfully borrowed " + bookTitle);
                    return;
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }

    public void printAvailableBooks() {
        if(!libraryBookCollection.isEmpty()) {
            for(Book book : libraryBookCollection) {
                if(!book.borrowed) {
                    System.out.println(book.getTitle());
                }
            }
        } else {
            System.out.println("No book in catalog");
        }
    }

    public void returnBook(String bookTitle) {
        for(Book book : libraryBookCollection) {
            if(book.getTitle().equalsIgnoreCase(bookTitle)) {
                book.returned();
                System.out.printf("You successfully returned %s", bookTitle);
            }
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

//        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
//
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

//        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
//
//        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
//
//        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
//
//        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}