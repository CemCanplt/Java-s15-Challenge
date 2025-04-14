package com.library.model;

import java.util.Date;

// Magazine sınıfı (Book'tan extend)
public class Magazine extends Book {
    public Magazine(String bookID, String name, String author, double price, String edition, Date dateOfPurchase) {
        super(bookID, name, author, price, edition, dateOfPurchase);
    }
}
