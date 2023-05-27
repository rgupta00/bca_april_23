package com.bankapp.service.impl;

import com.bankapp.dto.AccountContactDto;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import com.bankapp.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account getById(int id) {
        return accountRepo.findById(id).orElseThrow(() -> new BankAccountNotFoundException("account with id" +
                " "+ id +" is not found"));
    }

    @Override
    public void deposit(int id, BigDecimal amount) {
        Account account = getById(id);
        account.setBalance(account.getBalance().add(amount));
        accountRepo.save(account);
    }

    @Override
    public void withdraw(int id, BigDecimal amount) {
        Account account = getById(id);
        account.setBalance(account.getBalance().subtract(amount));
        accountRepo.save(account);
    }

    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        //Raj         Ekta
        //A         -> B
        Account fromAcc = getById(fromId);
        Account toAcc = getById(toId);

        fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
        toAcc.setBalance(toAcc.getBalance().add(amount));

        accountRepo.save(fromAcc);
//        if(1==1){
//            throw new NullPointerException("some random ex!");
//        }
        accountRepo.save(toAcc);
    }

    @Override
    public void addAccount(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountRepo.delete(getById(id));
    }

    @Override
    public void updateContactDetails(int id, AccountContactDto contactDto) {
        Account account = getById(id);
        account.setEmail(contactDto.getEmail());
        account.setPhone(contactDto.getPhone());
        accountRepo.save(account);
    }
}

















