package com.example.banksystem.cbts.response;

import java.math.BigDecimal;

public class CashResponse {
    public String currency;
    public BigDecimal amount;

    public CashResponse() {
    }

    public CashResponse(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
