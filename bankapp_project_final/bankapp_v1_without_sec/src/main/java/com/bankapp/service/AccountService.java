package com.bankapp.service;

import com.bankapp.dto.AccountContactDto;
import com.bankapp.entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public List<Account> getAll();
    public Account getById(int id);

    public void deposit(int id, BigDecimal amount);
    public void withdraw(int id, BigDecimal amount);
    public void transfer(int fromId, int toId, BigDecimal amount);

    public void addAccount(Account account);
    public void deleteAccount(int id);

    public void updateContactDetails(int id, AccountContactDto contactDto);

}
