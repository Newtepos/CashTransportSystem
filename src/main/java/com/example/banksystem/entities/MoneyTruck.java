package com.example.banksystem.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MoneyTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long TruckID;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CashPackage> cashPackageList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moneyTruck")
    private List<Location> locationList = new ArrayList<>();

    public MoneyTruck() {
    }

    public MoneyTruck(List<CashPackage> cashPackageList, List<Location> locations) {
        this.cashPackageList = cashPackageList;
        this.locationList = locations;
    }

    public List<CashPackage> getCashPackageList() {
        return cashPackageList;
    }

    public void setCashPackageList(List<CashPackage> cashPackageList) {
        this.cashPackageList = cashPackageList;
    }

    public List<Location> getLocations() {
        return locationList;
    }

    public void setLocations(List<Location> locations) {
        this.locationList = locations;
    }

    public void addPackage(CashPackage cashPackage) {
        cashPackageList.add(cashPackage);
    }

    public void addLocation(Location location) {
        locationList.add(location);
    }
}
