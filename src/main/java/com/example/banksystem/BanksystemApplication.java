package com.example.banksystem;

import com.example.banksystem.entities.*;
import com.example.banksystem.repository.BankRepositry;
import com.example.banksystem.repository.MoneyTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BanksystemApplication {

	@Autowired
	MoneyTruckRepository moneyTruckRepository;

	@Autowired
	BankRepositry bankRepositry;

	@PostConstruct
	public void initData() {
		Bank bank1 = new Bank("Cash Center");
		Bank bank2 = new Bank("Branch 1");
		bankRepositry.save(bank1);
		bankRepositry.save(bank2);

		bank1.setBankName("KBTG");
		Cash cash = new Cash("USD", 200000.12312312);
		MoneyTruck moneyTruck = new MoneyTruck();
		CashPackage cashPackage = new CashPackage(cash,bank1,bank2,moneyTruck);
		Location location = new Location(12.12,12.12, moneyTruck);
		Location location2 = new Location(12.12,12.12,moneyTruck);
		moneyTruck.addPackage(cashPackage);
		moneyTruck.addLocation(location);

		moneyTruckRepository.save(moneyTruck);

		moneyTruck.addLocation(location2);
		moneyTruckRepository.save(moneyTruck);

	}

	public static void main(String[] args) {
		SpringApplication.run(BanksystemApplication.class, args);
	}

}
