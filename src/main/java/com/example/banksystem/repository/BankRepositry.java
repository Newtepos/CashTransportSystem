package com.example.banksystem.repository;

import com.example.banksystem.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepositry extends JpaRepository<Bank, Long> {
}
