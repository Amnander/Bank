package com.banking.BankingApp.controller;

import com.banking.BankingApp.entity.AccountEntity;
import com.banking.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController
{
    @Autowired
    AccountService service;

    @GetMapping("/accounts")
    public List<AccountEntity> getAccounts()
    {
        return service.getAccounts();
    }

    @GetMapping("/accounts/{accId}")
    public AccountEntity getAccountId(@PathVariable int accId)
    {
        return service.getAccountByAccountId(accId);
    }

    @PostMapping("/account")
    public void addAccount(@RequestBody AccountEntity account)
    {
        System.out.println(account);
        service.addAccount(account);
    }

    @PutMapping("/accounts/{accountNumber}/amount/{amount}")
    public void deposit(@PathVariable int accountNumber, @PathVariable double amount)
    {
        service.deposit(amount, accountNumber);
    }
}
