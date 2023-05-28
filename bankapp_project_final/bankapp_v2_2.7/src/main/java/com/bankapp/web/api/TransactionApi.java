package com.bankapp.web.api;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transactions")
public class TransactionApi {

    @Autowired
    private AccountService accountService;

    //How to handle ex: AOP CCC
    //fund transfer
    @PostMapping("transfer")
    public String transfer( @RequestBody TransferDto transferDto){
        accountService.transfer(transferDto.getFromAccId(), transferDto.getToAccId(), transferDto.getAmount());
        return  "fund is transfered successfull form acc "+
                (transferDto.getFromAccId() +" to "+transferDto.getToAccId()+" amount "+transferDto.getAmount());
    }

    //deposit
    @PostMapping("deposit")
    public String deposit(@RequestBody DepositDto depositDto){
        accountService.deposit(depositDto.getAccId(),depositDto.getAmount() );
        return  "amout is deposited successfull to acc "+
                depositDto.getAccId() +" and amount is "+ depositDto.getAmount();
    }

    //withdraw
    @PostMapping("withdraw")
    public String withdraw(@RequestBody WithdrawDto withdrawDto){
        accountService.withdraw(withdrawDto.getAccId(),withdrawDto.getAmount() );
        return  "amout is withdraw successfull from acc "+
                withdrawDto.getAccId() +" and amount is "+ withdrawDto.getAmount();
    }


}
















