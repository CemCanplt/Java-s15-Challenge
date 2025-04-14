package model0;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// model/Reader.java
public class Reader extends Person {
    private Set<Book> borrowedBooks = new HashSet<>();

    public Reader(String name) {
        super(name);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am reader: " + getName());
    }

    public boolean purchaseBook(Book book) {

        if (book.getStatus().equals(Status.AVAILABLE)) {
            book.setStatus(Status.SOLD);
            return true;
        }
        return false;

    }

    public boolean borrowBook(Book book) {
        if (borrowedBooks.size() < 5 && book.getStatus().equals(Status.AVAILABLE)) {
            borrowedBooks.add(book);
            book.setStatus(Status.BORROWED);
            return true;
        }
        return false;
    }



    public boolean returnBook(Book book) {
        if (book.getStatus().equals(Status.BORROWED)) {
            book.setStatus(Status.AVAILABLE);
            borrowedBooks.remove(book);
            return true;
        }
        return false;
    }

    public void showBook() {
        for (Book book : borrowedBooks) {
            System.out.println(book.toString());
        }

    }

    public Set<Book> getBorrowedBooks() {
        return Collections.unmodifiableSet(borrowedBooks);
    }


}




















