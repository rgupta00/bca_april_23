package com.bankapp;

import com.bankapp.entities.Account;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class BankappV1Application{
	@Autowired
	private AccountRepo accountRepo;

	public static void main(String[] args) {
		SpringApplication.run(BankappV1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args )->{
			accountRepo.save(new Account("amit", BigDecimal.valueOf(1000),"amit@gmail.com","8899776600"));
			accountRepo.save(new Account("sumit", BigDecimal.valueOf(1000),"sumit@gmail.com","8009776600"));

			System.out.println("---------------------------");
		};
	}
}



















