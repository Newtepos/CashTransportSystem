package com.example.banksystem.cbts.controller;

import com.example.banksystem.AppResponse;
import com.example.banksystem.cbts.exception.BankNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CBTSControllerAdvice {

    @ExceptionHandler(BankNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AppResponse bankNotFound(BankNotFoundException e) {
        return new AppResponse(e.getMessage());
    }
}
