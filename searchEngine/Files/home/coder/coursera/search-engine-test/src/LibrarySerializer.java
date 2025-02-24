
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.ObjectOutputStream;
public class LibrarySerializer {

    public void saveLibrary(List<Book> books, String fileName) {

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(books);
            System.out.println("Library saved successfully.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
        public List<Book> loadLibrary(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            return null;
        }

        try
                (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // TODO - missing code
            List<Book> book = (List<Book>) ois.readObject();
            System.out.println("Library loaded successfully.");
        }
        catch (EOFException e) {
            System.err.println("The file is empty or corrupted: " + fileName);
            return null;
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
            return null;
    }
}

