package com.example.banksystem.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class CashPackage {

    @Id
    @GeneratedValue
    private UUID ID;

    @OneToOne(cascade = CascadeType.ALL)
    private Cash cash;

    @ManyToOne
    private Bank sender;

    @ManyToOne
    private Bank reciver;

    @ManyToOne
    private MoneyTruck moneyTruck;

    public CashPackage() {
    }

    public CashPackage(Cash cash, Bank sender, Bank reciver, MoneyTruck moneyTruck) {
        this.cash = cash;
        this.sender = sender;
        this.reciver = reciver;
        this.moneyTruck = moneyTruck;
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public Bank getSender() {
        return sender;
    }

    public void setSender(Bank sender) {
        this.sender = sender;
    }

    public Bank getReciver() {
        return reciver;
    }

    public void setReciver(Bank reciver) {
        this.reciver = reciver;
    }

    public MoneyTruck getMoneyTruck() {
        return moneyTruck;
    }

    public void setMoneyTruck(MoneyTruck moneyTruck) {
        this.moneyTruck = moneyTruck;
    }
}
