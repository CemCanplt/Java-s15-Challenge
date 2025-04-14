package model0;

import java.util.ArrayList;
import java.util.List;

// model/Author.java
public class Author extends Person {
    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        super(name);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am author: " + getName());
    }

    public void addNewBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        books.forEach(System.out::println);
    }
}
