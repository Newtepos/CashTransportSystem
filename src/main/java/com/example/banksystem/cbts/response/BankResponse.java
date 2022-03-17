package com.example.banksystem.cbts.response;

import java.util.List;

public class BankResponse {
    public String bank;

    public List<CashResponse> cashList;

    public BankResponse() {
    }

    public BankResponse(String bank, List<CashResponse> cashList) {
        this.bank = bank;
        this.cashList = cashList;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public List<CashResponse> getCashList() {
        return cashList;
    }

    public void setCashList(List<CashResponse> cashList) {
        this.cashList = cashList;
    }
}
