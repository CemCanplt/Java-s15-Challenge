package com.library.model;

import java.util.Date;

// Abstract MemberRecord sınıfı
public abstract class MemberRecord {
    private String memberId;
    private String type; // Örn: "Student" veya "Faculty"
    private Date dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;

    public MemberRecord(String memberId, String type, Date dateOfMembership, int maxBookLimit,
                        String name, String address, String phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.maxBookLimit = maxBookLimit;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.noBooksIssued = 0;
    }

    public String getMemberId() { return memberId; }
    public int getNoOfBooksIssued() { return noBooksIssued; }
    public int getMaxBookLimit() { return maxBookLimit; }

    public void incBooksIssued() {
        noBooksIssued++;
    }

    public void decBooksIssued() {
        if(noBooksIssued > 0)
            noBooksIssued--;
    }

    public abstract void payBill(double amount);
}