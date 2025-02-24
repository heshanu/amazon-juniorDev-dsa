
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        library.loadBooks("src/resources/data/books.txt");

        LibraryMenu menu = new LibraryMenu(library);

        menu.displayMenu();

        UserInteractionLogger logger = new UserInteractionLogger();
        logger.log("Program started and menu displayed.");

        library.viewAllBooks();
        logger.log("Viewed all books.");

        SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
        logger.log("Sorted books by title.");
    }
}
