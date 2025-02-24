
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 for Viewing all books");
            System.out.println("2 for Sorting books by title");
            System.out.println("3 for Sorting book by author");
            System.out.println("4 for Sorting book by publisher");
            System.out.println("5 for searching for book by key");
            System.out.println(" 6 Exit");
            int answer= scanner.nextInt();
            switch(answer){
                case 1:
                    library.viewAllBooks();
                    break;
                case 2:
                    SortUtil.bubbleSort(library.getBooks(),Comparator.comparing(Book::getTitle));
                    library.viewAllBooks();
                    break;
                case 3:
                    SortUtil.insertionSort(library.getBooks(),Comparator.comparing(Book::getAuthor));
                    library.viewAllBooks();
                    break;
                case 4:
                    SortUtil.quickSort(library.getBooks(),Comparator.comparing(Book::getPublicationYear),0,library.getBooks().size());
                    library.viewAllBooks();
                    break;
                case 5:
                    System.out.println("Enter search keyword: ");
                    String keyword= scanner.nextLine();
                    library.searchBookByKeyword(keyword);
                    break;
                case 6:
                    System.exit(0);break;
                default:
                    break;
            }
            // TODO - missing code
        }
    }

}
