package com.bankapp.web.api;

import com.bankapp.dto.AccountContactDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//api/accounts/accounts
@RestController
@RequestMapping("api/accounts")
public class AccountCrudApi {

    @Autowired
    private AccountService accountService;

    //create
    @PostMapping(path = "accounts")
    public ResponseEntity<String> addAccount(@RequestBody Account account){
        accountService.addAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body("account is created successfully with id:"+ account.getId());
    }
    //update contact details
    @PutMapping(path = "accounts/{accountId}")
    public String updateAccount(@PathVariable(name ="accountId" ) int accountId,
                                @RequestBody AccountContactDto accountContactDto){
        accountService.updateContactDetails(accountId, accountContactDto);
        return "account contact details are updated successfully";
    }
    //delete

    @DeleteMapping(path = "accounts/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable(name ="accountId" ) int accountId){
        accountService.deleteAccount(accountId);
        System.out.println("account is deleted");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //getby id
    @GetMapping(path = "accounts/{accountId}")
    public Account getByIdAccount(@PathVariable(name ="accountId" )  int accountId) {
        return accountService.getById(accountId);
    }
    //getAll

    @GetMapping(path = "accounts")
    public List<Account> getAllAccount(){
        return accountService.getAll();
    }

}
















