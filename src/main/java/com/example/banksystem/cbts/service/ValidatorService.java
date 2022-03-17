package com.example.banksystem.cbts.service;

import com.example.banksystem.cbts.exception.BankNotFoundException;
import com.example.banksystem.cbts.exception.CashPackageNotFoundException;
import com.example.banksystem.entities.Bank;
import com.example.banksystem.entities.CashPackage;
import com.example.banksystem.entities.MoneyTruck;
import com.example.banksystem.repository.BankRepositry;
import com.example.banksystem.repository.CashPackageRepository;
import com.example.banksystem.repository.MoneyTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ValidatorService {

    @Autowired
    BankRepositry bankRepositry;

    @Autowired
    MoneyTruckRepository moneyTruckRepository;

    @Autowired
    CashPackageRepository cashPackageRepository;

    public Bank isBankIDExist(long ID, String address) {
        Optional<Bank> result = bankRepositry.findById(ID);
        if(!result.isPresent()) {
            throw new BankNotFoundException(address + "ID is Incorrect");
        }
        return result.get();
    }

    public MoneyTruck isTruckIDExist(long ID) {
        Optional<MoneyTruck> result = moneyTruckRepository.findById(ID);
        if(!result.isPresent()) {
            throw new BankNotFoundException("TruckID is Incorrect");
        }
        return result.get();
    }

    public CashPackage isCashPackageExist(UUID ID) {
       Optional<CashPackage> result = cashPackageRepository.findById(ID);
       if(!result.isPresent()) {
           throw new CashPackageNotFoundException("Cannot Found CashPackage");
       }
       return result.get();
    }
}
