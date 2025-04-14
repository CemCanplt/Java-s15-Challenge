package com.library.model;
import java.util.Date;

// Faculty sınıfı (MemberRecord'tan extend)
public class Faculty extends MemberRecord {
    public Faculty(String memberId, Date dateOfMembership, int maxBookLimit,
                   String name, String address, String phoneNo) {
        super(memberId, "Faculty", dateOfMembership, maxBookLimit, name, address, phoneNo);
    }

    @Override
    public void payBill(double amount) {
        System.out.println("Faculty " + getMemberId() + " paid bill: " + amount);
    }
}