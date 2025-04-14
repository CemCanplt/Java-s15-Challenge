package com.library.model;
import java.util.ArrayList;
import java.util.List;

// Reader sınıfı
public class Reader extends Person {
    private List<Book> books = new ArrayList<>();
    // Composition: Her Reader bir MemberRecord ile ilişkilidir.
    private MemberRecord memberRecord;

    public Reader(String name, MemberRecord memberRecord) {
        super(name);
        this.memberRecord = memberRecord;
    }

    public void purchaseBook(Book book) {
        System.out.println(getName() + " purchased the book: " + book.getName());
    }

    public void borrowBook(Book book) {
        if(memberRecord.getNoOfBooksIssued() < memberRecord.getMaxBookLimit()){
            books.add(book);
            memberRecord.incBooksIssued();
            System.out.println(getName() + " borrowed the book: " + book.getName());
        } else {
            System.out.println(getName() + " has reached the book limit!");
        }
    }

    public void returnBook(Book book) {
        if(books.remove(book)) {
            memberRecord.decBooksIssued();
            System.out.println(getName() + " returned the book: " + book.getName());
        } else {
            System.out.println("Book not found in " + getName() + "'s borrowed list.");
        }
    }

    public void showBook() {
        System.out.println(getName() + "'s books:");
        for (Book book : books) {
            System.out.println(book.getName());
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("I'm a Reader named " + getName());
    }
}