package model;

import java.util.List;

public class Librarian {
    private String name;
    private String password;
    private Library library;

    public Librarian(String name, String password, Library library) {
        this.name = name;
        this.password = password;
        this.library = library;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Book searchBookById(long id) {
        return library.getBookById(id);
    }

    public List<Book> searchBookByName(String name) {
        return library.getBookByName(name);
    }

    public List<Book> searchBookByAuthor(String author) {
        return library.getBookByAuthor(author);
    }

    public boolean returnBook(Book book) {
        if (book.getStatus().equals(Status.BORROWED)) {
            for (Reader reader: library.getReaders()) {
                for (Book book1: reader.getBorrowedBooks()) {
                    if (book.equals(book1)) {
                        returnBook(book1, reader);
                    }
                }
            }
            return true;
        }
        return false;
    }


    public boolean returnBook(Book book, Reader reader) {
        System.out.println("Başarılı");
        System.out.println("Kitabın geri alındığı kişi: " + reader);
        return library.takeBackBook(book, reader);

    }

    public MemberType verifyMember(MemberRecord member) {

        if (member.getMemberType() == null) {
            System.out.println("Üye kayıtlı değil.");
        }

        return member.getMemberType();
    }

    public


}































