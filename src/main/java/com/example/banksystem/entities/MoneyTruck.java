package com.example.banksystem.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class MoneyTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long TruckID;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CashPackage> cashPackageList;

    private Location location;

    public MoneyTruck() {
    }

    public MoneyTruck(List<CashPackage> cashPackageList, Location location) {
        this.cashPackageList = cashPackageList;
        this.location = location;
    }

    public long getTruckID() {
        return TruckID;
    }

    public void setTruckID(long truckID) {
        TruckID = truckID;
    }

    public List<CashPackage> getCashPackageList() {
        return cashPackageList;
    }

    public void setCashPackageList(List<CashPackage> cashPackageList) {
        this.cashPackageList = cashPackageList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
