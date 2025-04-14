package com.library.model;
import java.util.Date;

// Journal sınıfı (Book'tan extend)
public class Journal extends Book {
    public Journal(String bookID, String name, String author, double price, String edition, Date dateOfPurchase) {
        super(bookID, name, author, price, edition, dateOfPurchase);
    }
}