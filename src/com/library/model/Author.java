package com.library.model;
import java.util.ArrayList;
import java.util.List;

// Author sınıfı
public class Author extends Person {
    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        super(name);
    }

    public void newBook(Book book) {
        books.add(book);
    }

    public void showBook() {
        System.out.println("Books by " + getName() + ":");
        for (Book book : books) {
            System.out.println(book.getName());
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("I'm an Author named " + getName());
    }
}