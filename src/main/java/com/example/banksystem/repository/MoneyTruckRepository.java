package com.example.banksystem.repository;

import com.example.banksystem.entities.MoneyTruck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyTruckRepository extends JpaRepository<MoneyTruck,Long> {
}
