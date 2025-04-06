import model.Book;
import model.Librarian;
import model.Library;
import model.Reader;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Library library = new Library();

        Librarian Mehmet = new Librarian("Mehmet", "Mehmet1453", library);

        System.out.println(Mehmet.searchBookById(1L)); //Null

        Reader reader = new Reader("Ali");

        Book deli = new Book(2L, "Ali Alioğlu", "Nasıl zengin olunur?", 6783, 3, "23/12/2002");

        library.addNewBook(deli);
        library.addReader(reader);

        reader.borrowBook(deli);

        Mehmet.returnBook(deli, reader);
    }
}