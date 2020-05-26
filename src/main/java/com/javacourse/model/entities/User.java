package com.javacourse.model.entities;

import com.javacourse.model.TaxGroup;

public class User extends Account{
    private String fullName;
    private String company;
    private String passport;
    private String address;
    private TaxGroup group;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getPassport() {
        return passport;
    }
    public void setPassport(String passport) {
        this.passport = passport;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public TaxGroup getGroup() {
        return group;
    }
    public void setGroup(TaxGroup group) {
        this.group = group;
    }

}

