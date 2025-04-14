package model0;

import java.util.*;

// model/Library.java
public class Library {

    private Map<Long, Book> books = new HashMap<>();;
    private List<Reader> readers = new ArrayList<>();

    // Okay
    public void addNewBook(Book book) {
        books.put(book.getBook_ID(), book);
    }

    public Library(Map<Long, Book> books, List<Reader> readers) {
        this.books = books;
        this.readers = readers;
    }

    public Library() {
    }


    // Okay
    public void lendBook(Book book, Reader reader) {
        reader.borrowBook(book);
    }

    // Okay
    public boolean takeBackBook(Book book, Reader reader) {
         return reader.returnBook(book);
    }

    // Okay
    public Map<Long, Book> getBooks() {
        return Collections.unmodifiableMap(books); // Değiştirilemez bir görünüm döndürür
    }

    // Reader ekleme + bonus
    public void addReader(Reader reader) {
        readers.add(reader);
    }

    // Okay
    public List<Reader> getReaders() {
        return Collections.unmodifiableList(readers);
    }


//    public List<Book> getBook(int sayi, String nameOfBookOrAuthor) {
//        List<Book> matchingBooks = new ArrayList<>();
//
//
//        if (sayi == 0) {
//            // Map üzerinde değer bazlı döngü
//            for (Book book : books.values()) {
//                if (book.getBookName().equalsIgnoreCase(nameOfBookOrAuthor)) { // Kitap ismini kontrol ediyoruz
//                    matchingBooks.add(book); // Eşleşen kitapları listeye ekliyoruz
//                }
//            }
//
//        } else if (sayi == 1) {
//            for (Book book : books.values()) {
//                if (book.getAuthor().equalsIgnoreCase(nameOfBookOrAuthor)) {
//                    matchingBooks.add(book);
//                }
//            }
//        } else {
//            System.out.println("Yanlış sayı değeri girildi.");
//        }
//
//        return matchingBooks;
//
//    }

    public Book getBookById(long id) {
        return books.get(id);
    }

    public List<Book> getBookByName(String name) {
        List<Book> matchingBooks = new ArrayList<>();

        for (Book book : books.values()) {
                if (book.getBookName().equalsIgnoreCase(name)) { // Kitap ismini kontrol ediyoruz
                    matchingBooks.add(book); // Eşleşen kitapları listeye ekliyoruz
                }
            }

        return matchingBooks;

    }

    public List<Book> getBookByAuthor(String author) {
        List<Book> matchingBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }


}


























