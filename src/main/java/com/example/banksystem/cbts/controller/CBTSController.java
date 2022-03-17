package com.example.banksystem.cbts.controller;

import com.example.banksystem.cbts.request.RequestPackage;
import com.example.banksystem.cbts.response.BankResponse;
import com.example.banksystem.cbts.service.CBTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CBTSController {

    @Autowired
    CBTSService cbtsService;


    @GetMapping("/bank")
    public ResponseEntity getAllBank() {
        List<BankResponse> result = cbtsService.getAllBank();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bank/{id}")
    public ResponseEntity getBankbyID(@PathVariable long id) {
        BankResponse response = cbtsService.getBankById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/package")
    public ResponseEntity createPackage(@RequestBody RequestPackage requestPackage) {
        Long senderID = requestPackage.getSenderID();
        Long receiverID = requestPackage.getReceiverID();
        Long truckID = requestPackage.getTruckID();
        String currency = requestPackage.getCurrency();
        double amount = requestPackage.getAmount();
        cbtsService.createPackage(senderID,receiverID,truckID,currency,amount);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
