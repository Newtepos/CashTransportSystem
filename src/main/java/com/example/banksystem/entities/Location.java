package com.example.banksystem.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private double latitude;
    private double longitude;

    private Timestamp timestamp;

    @ManyToOne
    private MoneyTruck moneyTruck;

    public Location() {
    }

    public Location(double latitude, double longitude, MoneyTruck moneyTruck, Timestamp timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.moneyTruck = moneyTruck;
        this.timestamp = timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public MoneyTruck getMoneyTruck() {
        return moneyTruck;
    }

    public void setMoneyTruck(MoneyTruck moneyTruck) {
        this.moneyTruck = moneyTruck;
    }
}
