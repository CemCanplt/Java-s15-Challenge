package com.library.service;
import com.library.model.Book;
import com.library.model.Reader;

import java.util.*;

public class Library {
    // Kitapların Listesi (List kullanıldı)
    private List<Book> books = new ArrayList<>();
    // Reader nesneleri için Map (örneğin: memberId veya isim ile)
    private Map<String, Reader> readers = new HashMap<>();
    // Librarian nesnelerini depolamak için Set kullanımı (benzersiz kayıtlar)
    private Set<Librarian> librarians = new HashSet<>();

    public List<Book> getBooks() {
        return books;
    }

    public Reader getReader(String key) {
        return readers.get(key);
    }

    public void newBook(Book book) {
        books.add(book);
        System.out.println("New book added: " + book.getName());
    }

    public void lendBook(String bookID, Reader reader) {
        Optional<Book> optionalBook = books.stream()
                .filter(b -> b.getBookID().equals(bookID) && b.getStatus().equals("Available"))
                .findFirst();
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            reader.borrowBook(book);
            book.changeOwner(reader);
            book.updateStatus("Borrowed");
        } else {
            System.out.println("Book not available for lending.");
        }
    }

    public void takeBackBook(String bookID, Reader reader) {
        Optional<Book> optionalBook = books.stream()
                .filter(b -> b.getBookID().equals(bookID))
                .findFirst();
        if(optionalBook.isPresent()){
            Book book = optionalBook.get();
            reader.returnBook(book);
            book.changeOwner(null); // Kütüphaneye geri dönmüş durumda.
            book.updateStatus("Available");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void showBook() {
        for(Book book : books)
            book.display();
    }

    public void registerReader(Reader reader) {
        // Örneğin, memberId veya isim kullanılabilir.
        readers.put(reader.getName(), reader);
    }

    public void registerLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }
}