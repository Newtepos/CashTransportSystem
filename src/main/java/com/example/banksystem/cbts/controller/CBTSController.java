package com.example.banksystem.cbts.controller;

import com.example.banksystem.cbts.response.BankResponse;
import com.example.banksystem.cbts.service.CBTSService;
import com.example.banksystem.entities.Bank;
import com.example.banksystem.repository.BankRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
