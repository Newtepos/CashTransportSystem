package com.example.banksystem.cbts.exception;

public class BankNotFoundException extends RuntimeException {
    public BankNotFoundException(String name) {
        super(name);
    }
}
