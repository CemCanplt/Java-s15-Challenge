package model0;

import java.util.Objects;

public class Book {
    private long book_ID;
    private String author;
    private String bookName;
    private int price;
    private Status status;
    private int edition;
    private String date_of_purchase;


    public Book(long book_ID, String author, String bookName, int price, int edition, String date_of_purchase) {
        this.book_ID = book_ID;
        this.author = author;
        this.bookName = bookName;
        this.price = price;
        this.status = Status.AVAILABLE;
        this.edition = edition;
        this.date_of_purchase = date_of_purchase;
    }

    public long getBook_ID() {
        return book_ID;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public int getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public int getEdition() {
        return edition;
    }

    public String getDateOfPurchase() {
        return date_of_purchase;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(String date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_ID == book.book_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(book_ID);
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", date_of_purchase='" + date_of_purchase + '\'' +
                '}';
    }
}
