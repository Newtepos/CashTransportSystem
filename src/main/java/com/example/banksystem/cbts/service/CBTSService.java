package com.example.banksystem.cbts.service;

import com.example.banksystem.cbts.exception.BankNotFoundException;
import com.example.banksystem.cbts.response.BankResponse;
import com.example.banksystem.cbts.response.CashResponse;
import com.example.banksystem.entities.Bank;
import com.example.banksystem.entities.Cash;
import com.example.banksystem.entities.CashPackage;
import com.example.banksystem.entities.MoneyTruck;
import com.example.banksystem.repository.BankRepositry;
import com.example.banksystem.repository.CashPackageRepository;
import com.example.banksystem.repository.MoneyTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CBTSService {

    @Autowired
    CashPackageRepository cashPackageRepository;

    @Autowired
    BankRepositry bankRepositry;

    @Autowired
    MoneyTruckRepository moneyTruckRepository;

    @Autowired
    ValidatorService validatorService;

    public List<BankResponse> getAllBank() {
        List<Bank> bankList = bankRepositry.findAll();
        List<BankResponse> bankResponseList = new ArrayList<>();

        //If Empty throw exception
        if(bankList.isEmpty()) {
            throw new BankNotFoundException("No Bank in Database");
        }

        for(Bank bank: bankList) {
            BankResponse bankResponse = new BankResponse();
            List<CashResponse> cashResponseList = new ArrayList<>();

            List<Cash> cashList = bank.getCashList();
            for(Cash cash: cashList) {
                CashResponse cashResponse = new CashResponse(cash.getCurrency(), cash.getAmount());
                cashResponseList.add(cashResponse);
            }
            bankResponse.setBank(bank.getBankName());
            bankResponse.setCashList(cashResponseList);
            bankResponseList.add(bankResponse);
        }

        return bankResponseList;
    }

    public BankResponse getBankById(Long id) {
        Optional<Bank> queryResult = bankRepositry.findById(id);
        BankResponse bankResponse = new BankResponse();
        List<CashResponse> cashResponseList = new ArrayList<>();

        if(queryResult.isEmpty()) {
            throw new BankNotFoundException("BankID is incorrect");
        }

        for(Cash cash: queryResult.get().getCashList()) {
            CashResponse cashResponse = new CashResponse(cash.getCurrency(),cash.getAmount());
        }

        bankResponse.setCashList(cashResponseList);
        bankResponse.setBank(queryResult.get().getBankName());

        return bankResponse;
    }

    public UUID createPackage(Long senderID, Long receiverID, Long truckID, String currency, double amount) {
        //Validate Data
        Bank sender = validatorService.isBankIDExist(senderID, "Sender");
        Bank receiver = validatorService.isBankIDExist(receiverID, "Receiver");
        MoneyTruck truck = validatorService.isTruckIDExist(truckID);

        //Create Class and Save
        Cash cash = new Cash(currency, amount);
        CashPackage cashPackage = new CashPackage(cash, sender, receiver, truck);
        cashPackageRepository.save(cashPackage);

       return cashPackage.getID();
    }

    public void sentCashPackage(UUID packageID) {
        CashPackage cashPackage = validatorService.isCashPackageExist(packageID);
        cashPackage.setSent(true);
        cashPackageRepository.save(cashPackage);
    }
}
