package com.library.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Member {
    private String memberId;
    private String name;
    private int maxBookLimit = 5;
    private Set<Book> borrowedBooks = new HashSet<>();

    public boolean canBorrow() {
        return borrowedBooks.size() < maxBookLimit;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Diğer metodlar...
}