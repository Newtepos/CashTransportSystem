package com.example.banksystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Cash {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private String Currency;
    private BigDecimal Amount;

    public Cash() {
    }

    public Cash(String currency, BigDecimal amount) {
        Currency = currency;
        Amount = amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }
}
