package com.example.banksystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private String bankName;

    private List<Cash> cashList;

    public Bank() {
    }

    public Bank(String bankName, List<Cash> cashList) {
        this.bankName = bankName;
        this.cashList = cashList;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Cash> getCashList() {
        return cashList;
    }

    public void setCashList(List<Cash> cashList) {
        this.cashList = cashList;
    }
}
