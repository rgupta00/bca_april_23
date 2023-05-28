package com.bankapp;

import com.bankapp.entities.Account;
import com.bankapp.entities.UserEntity;
import com.bankapp.repo.AccountRepo;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BankappV1Application{
	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BankappV1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args )->{
			accountRepo.save(new Account("amit", BigDecimal.valueOf(1000),"amit@gmail.com","8899776600"));
			accountRepo.save(new Account("sumit", BigDecimal.valueOf(1000),"sumit@gmail.com","8009776600"));
		//String username, String password, List<String> roles
			userService.addUser(new UserEntity("raj",passwordEncoder.encode("raj123"), List.of("ROLE_MGR","ROLE_CLERK")));
			userService.addUser(new UserEntity("ekta",passwordEncoder.encode("ekta123"), List.of("ROLE_CLERK")));

			System.out.println("---------------------------");
		};
	}
}



















