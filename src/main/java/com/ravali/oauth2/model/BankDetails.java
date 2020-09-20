package com.ravali.oauth2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String accountNumber;
    private String bankName;
    private String branch;
    private String ifscCode;
    private String passbook_img;
    private String nameOnPassbook;

    public BankDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getPassbook_img() {
        return passbook_img;
    }

    public void setPassbook_img(String passbook_img) {
        this.passbook_img = passbook_img;
    }

    public String getNameOnPassbook() {
        return nameOnPassbook;
    }

    public void setNameOnPassbook(String nameOnPassbook) {
        this.nameOnPassbook = nameOnPassbook;
    }
}
