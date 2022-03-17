package com.example.banksystem.cbts.request;

import java.math.BigDecimal;

public class RequestPackage {
    private long senderID;
    private long receiverID;
    private long truckID;
    private String currency;
    private double amount;

    public RequestPackage(long senderID, long receiverID, long truckID, String currency, double amount) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.truckID = truckID;
        this.currency = currency;
        this.amount = amount;
    }

    public long getSenderID() {
        return senderID;
    }

    public void setSenderID(long senderID) {
        this.senderID = senderID;
    }

    public long getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(long receiverID) {
        this.receiverID = receiverID;
    }

    public long getTruckID() {
        return truckID;
    }

    public void setTruckID(long truckID) {
        this.truckID = truckID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
