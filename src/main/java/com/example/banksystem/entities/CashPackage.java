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
    private Bank receiver;

    @ManyToOne
    private MoneyTruck moneyTruck;

    private Boolean sent = false;
    private Boolean received = false;

    public CashPackage() {
    }

    public CashPackage(Cash cash, Bank sender, Bank receiver, MoneyTruck moneyTruck) {
        this.cash = cash;
        this.sender = sender;
        this.receiver = receiver;
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

    public Bank getReceiver() {
        return receiver;
    }

    public void setReceiver(Bank receiver) {
        this.receiver = receiver;
    }

    public MoneyTruck getMoneyTruck() {
        return moneyTruck;
    }

    public void setMoneyTruck(MoneyTruck moneyTruck) {
        this.moneyTruck = moneyTruck;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }
}
