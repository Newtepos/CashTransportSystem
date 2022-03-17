package com.example.banksystem.cbts.controller;

import com.example.banksystem.cbts.request.RequestPackage;
import com.example.banksystem.cbts.response.BankResponse;
import com.example.banksystem.cbts.service.CBTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        UUID uuid = cbtsService.createPackage(senderID,receiverID,truckID,currency,amount);
        return new ResponseEntity<>(uuid, HttpStatus.OK);
    }

    @PostMapping("/package/sent")
    public ResponseEntity sentCashPackage(@RequestParam String id) {
        UUID uuid = UUID.fromString(id);
        cbtsService.sentCashPackage(uuid);
        return new ResponseEntity<>("Packaged Sent", HttpStatus.OK);
    }

}
