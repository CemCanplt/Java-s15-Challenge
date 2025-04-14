package com.library.model;
import java.util.Date;

// Student sınıfı (MemberRecord'tan extend)
public class Student extends MemberRecord {
    public Student(String memberId, Date dateOfMembership, int maxBookLimit,
                   String name, String address, String phoneNo) {
        super(memberId, "Student", dateOfMembership, maxBookLimit, name, address, phoneNo);
    }

    @Override
    public void payBill(double amount) {
        System.out.println("Student " + getMemberId() + " paid bill: " + amount);
    }
}