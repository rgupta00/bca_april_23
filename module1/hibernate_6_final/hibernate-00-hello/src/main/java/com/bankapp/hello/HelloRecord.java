package com.bankapp.hello;

import java.math.BigDecimal;

public class HelloRecord {

    public static void main(String[] args) {
        AccountDto account=new AccountDto("sunita", new BigDecimal(1000));
        AccountDto account2=new AccountDto("sunita", new BigDecimal(1000));

        if(account.equals(account2)){
            System.out.println("EEQ");
        }
        System.out.println(account.name());
        System.out.println(account. balance());
        System.out.println(account);


    }
}
