package com.example.banksystem.cbts.controller;

import com.example.banksystem.cbts.exception.TruckNotFoundException;
import com.example.banksystem.cbts.response.CBTSResponse;
import com.example.banksystem.cbts.exception.BankNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.transaction.TransactionalException;

@RestControllerAdvice
public class CBTSControllerAdvice {

    @ExceptionHandler(BankNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CBTSResponse bankNotFound(BankNotFoundException e) {
        return new CBTSResponse(e.getMessage());
    }

    @ExceptionHandler(TruckNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CBTSResponse truckNotFound(TruckNotFoundException e) {
        return new CBTSResponse(e.getMessage());
    }
}
