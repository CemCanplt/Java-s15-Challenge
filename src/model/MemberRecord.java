package model;

import java.util.Collections;

public class MemberRecord {
    private long id;
    private MemberType memberType;
    private String dateOfMembership;
    private int bookIssued;
    private final int maxBookLimit = 5;
    private String name;
    private String address;
    private long phoneNumber;


    public MemberRecord(long id, MemberType memberType, String dateOfMembership, int bookIssued, String name, String address, long phoneNumber) {
        this.id = id;
        this.memberType = memberType;
        this.dateOfMembership = dateOfMembership;
        this.bookIssued = bookIssued;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public MemberRecord getMember() {
        return this;
    }

    public long getId() {
        return id;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public int getBookIssued() {
        return bookIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void increaseBookIssue() {
        if (bookIssued < maxBookLimit) {
            bookIssued++;
        } else {
            System.out.println("Üyenin kitap sayısı zaten " + maxBookLimit);
        }
    }

    public void increaseBookIssue(int x) {
        if ((bookIssued + x) < maxBookLimit) {
            bookIssued += x;
        } else {
            System.out.println("Toplam kitap limiti aşıyor " + "(" + maxBookLimit + " Adet)" );
        }
    }

    public void decreaseBookIssue() {
        if (0 < bookIssued) {
            bookIssued--;
        } else {
            System.out.println("Üyenin kitap sayısı sıfırın altına düşüyor.");
        }
    }

    public void decreaseBookIssue(int x) {
        if (0 < (bookIssued - x)) {
            bookIssued -= x;
        } else {
            System.out.println("Üyenin kitap sayısı sıfırın altına düşüyor.");;
        }
    }


    public void paySubBill() {
        switch (memberType) {
            case STUDENT:
                System.out.println("15 TL ödendi.");
            case TEACHER:
                System.out.println("35 TL ödendi.");
            case FULL:
                System.out.println("60 TL ödendi.");
            default: System.out.println("Üyenin tipi bulunamadı");
        }
    }


}


























