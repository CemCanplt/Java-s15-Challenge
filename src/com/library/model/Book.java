package com.library.model;
import java.util.Date;

// Book sınıfı
public class Book {
    private String bookID;
    private String author;
    private String name;
    private double price;
    private String status; // "Available", "Borrowed", vs.
    private String edition;
    private Date dateOfPurchase;
    private Person owner; // Kitabın sahibi veya kitabı ödünç alan kişi

    public Book(String bookID, String name, String author, double price, String edition, Date dateOfPurchase) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.price = price;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.status = "Available";
    }

    public String getBookID() { return bookID; }
    public String getAuthor() { return author; }
    public String getName() { return name; }
    public Person getOwner() { return owner; }

    public void changeOwner(Person newOwner) {
        this.owner = newOwner;
    }

    public String getEdition() {
        return edition;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void display() {
        System.out.println("ID: " + bookID + ", Name: " + name + ", Author: " + author +
                ", Price: " + price + ", Edition: " + edition + ", Status: " + status);
    }
}