package com.example.banksystem.cbts.exception;

public class TruckNotFoundException extends RuntimeException{
    public TruckNotFoundException(String name) {
        super(name);
    }
}
