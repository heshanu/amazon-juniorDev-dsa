
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookDetails=line.split(",");
                if(bookDetails.length==3){
                    String title=bookDetails[0].trim();
                    String author=bookDetails[1].trim();
                    int year= Integer.parseInt(bookDetails[2].trim());
                    Book book=new Book(title,author,year);
                    books.add(book);
                }else{
                    System.out.println("Invalild book data: "+line);
                }
               //  TODO - missing code
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByKeyword(String keyword) {
        // TODO missing code
        keyword=keyword.toLowerCase();
        for(Book book:books){
            if(book.getTitle().toLowerCase().contains(keyword)||
            book.getAuthor().toLowerCase().contains(keyword)||
                    Integer.toString(book.getPublicationYear()).contains(keyword)
            ){
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
