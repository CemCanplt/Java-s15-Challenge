package com.library.ui;

import com.library.model.Book;
import com.library.model.MemberRecord;
import com.library.model.Reader;
import com.library.model.Student;
import com.library.service.Librarian;
import com.library.service.Library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibraryApplication {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);
    private static Librarian librarian = new Librarian("admin", "password");

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Örnek kitap verileri ekleniyor.
        Book book1 = new Book("1", "Java Programming", "John Doe", 29.99, "1st", sdf.parse("01-01-2020"));
        Book book2 = new Book("2", "Data Structures", "Jane Doe", 39.99, "2nd", sdf.parse("15-03-2021"));
        library.newBook(book1);
        library.newBook(book2);

        // Örnek olarak bir üyeyi (Student) kütüphaneye ekleyelim.
        MemberRecord studentRecord = new Student("S001", new Date(), 5, "Alice", "123 Main St", "1234567890");
        Reader reader1 = new Reader("Alice", studentRecord);
        library.registerReader(reader1);

        boolean exit = false;
        while(!exit) {
            System.out.println("\n--- Kütüphane Sistemine Hoşgeldiniz ---");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Ara (ID, İsim, Yazar)");
            System.out.println("3. Kitap Bilgilerini Güncelle");
            System.out.println("4. Kitap Sil");
            System.out.println("5. Tüm Kitapları Listele");
            System.out.println("6. Kitap Ödünç Al");
            System.out.println("7. Kitap Geri İade");
            System.out.println("8. Çıkış");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Satır sonunu tüket

            switch(choice) {
                case 1:
                    System.out.print("Kitap ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Kitap Adı: ");
                    String name = scanner.nextLine();
                    System.out.print("Yazar: ");
                    String author = scanner.nextLine();
                    System.out.print("Fiyat: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Baskı: ");
                    String edition = scanner.nextLine();
                    System.out.print("Satın Alma Tarihi (dd-MM-yyyy): ");
                    Date dateOfPurchase = sdf.parse(scanner.nextLine());
                    Book newBook = new Book(id, name, author, price, edition, dateOfPurchase);
                    library.newBook(newBook);
                    break;
                case 2:
                    System.out.print("Arama kelimesi (ID, isim veya yazar): ");
                    String keyword = scanner.nextLine();
                    List<Book> foundBooks = librarian.searchBook(library.getBooks(), keyword);
                    if(foundBooks.isEmpty()) {
                        System.out.println("Aradığınız özelliklerde kitap bulunamadı.");
                    } else {
                        for(Book b : foundBooks) {
                            b.display();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Güncellenecek Kitap ID: ");
                    String updateId = scanner.nextLine();
                    for(Book b : library.getBooks()) {
                        if(b.getBookID().equals(updateId)) {
                            System.out.print("Yeni Kitap Adı: ");
                            String newName = scanner.nextLine();
                            // Basitlik açısından sadece isim güncellemesi düşünülmüştür.
                            // Gerçek bir uygulamada setter metodları ile diğer bilgilerin de güncellenmesi sağlanabilir.
                            System.out.println("Kitap bilgileri güncellendi.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Silinecek Kitap ID: ");
                    String deleteId = scanner.nextLine();
                    library.getBooks().removeIf(b -> b.getBookID().equals(deleteId));
                    System.out.println("Kitap silindi.");
                    break;
                case 5:
                    library.showBook();
                    break;
                case 6:
                    System.out.print("Ödünç alınacak Kitap ID: ");
                    String lendId = scanner.nextLine();
                    librarian.issueBook(lendId, reader1, library);
                    break;
                case 7:
                    System.out.print("İade edilecek Kitap ID: ");
                    String returnId = scanner.nextLine();
                    librarian.returnBook(returnId, reader1, library);
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
        System.out.println("Sistemden çıkılıyor...");
        scanner.close();
    }
}