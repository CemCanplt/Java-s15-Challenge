package com.library.service;
import com.library.model.Book;
import com.library.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Librarian {
    private String name;
    private String password;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public List<Book> searchBook(List<Book> books, String keyword) {
        List<Book> result = new ArrayList<>();
        for(Book book : books) {
            if(book.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getBookID().equalsIgnoreCase(keyword)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean verifyMember(String memberId, Library library) {
        Reader reader = library.getReader(memberId);
        if(reader != null) {
            System.out.println("Member verified: " + reader.getName());
            return true;
        }
        System.out.println("Member not found.");
        return false;
    }

    public void issueBook(String bookID, Reader reader, Library library) {
        library.lendBook(bookID, reader);
        createBill(reader, bookID);
    }

    public double calculateFine(Reader reader) {
        // Basit bir örnek: fine calculation mantığı buraya eklenebilir.
        return 0.0;
    }

    public void createBill(Reader reader, String bookID) {
        System.out.println("Bill created for " + reader.getName() + " for book " + bookID);
    }

    public void returnBook(String bookID, Reader reader, Library library) {
        library.takeBackBook(bookID, reader);
        System.out.println("Book " + bookID + " returned.");
    }

    // HashSet içerisinde benzersiz şekilde saklamak için equals() ve hashCode() override edildi.
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Librarian that = (Librarian) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}