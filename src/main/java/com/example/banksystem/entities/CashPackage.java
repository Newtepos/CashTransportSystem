package com.example.banksystem.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class CashPackage {

    @Id
    @GeneratedValue
    private UUID ID;

    @OneToOne
    private Cash cash;

    public CashPackage() {
    }

    public CashPackage(Cash cash) {
        this.cash = cash;
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }
}
