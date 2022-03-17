package com.example.banksystem.repository;

import com.example.banksystem.entities.CashPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CashPackageRepository extends JpaRepository<CashPackage, UUID> {
}
