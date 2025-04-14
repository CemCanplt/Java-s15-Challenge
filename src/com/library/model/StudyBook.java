package com.library.model;
import java.util.Date;

// StudyBook sınıfı (Book'tan extend)
public class StudyBook extends Book {
    public StudyBook(String bookID, String name, String author, double price, String edition, Date dateOfPurchase) {
        super(bookID, name, author, price, edition, dateOfPurchase);
    }
}