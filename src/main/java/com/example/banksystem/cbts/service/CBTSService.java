package com.example.banksystem.cbts.service;

import com.example.banksystem.cbts.exception.BankNotFoundException;
import com.example.banksystem.cbts.response.BankResponse;
import com.example.banksystem.cbts.response.CashResponse;
import com.example.banksystem.entities.Bank;
import com.example.banksystem.entities.Cash;
import com.example.banksystem.repository.BankRepositry;
import com.example.banksystem.repository.CashPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CBTSService {

    @Autowired
    CashPackageRepository cashPackageRepository;

    @Autowired
    BankRepositry bankRepositry;

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

}
