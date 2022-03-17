package com.example.banksystem.cbts.exception;

public class CashPackageNotFoundException extends RuntimeException{
    public CashPackageNotFoundException(String name) {
        super(name);
    }
}
