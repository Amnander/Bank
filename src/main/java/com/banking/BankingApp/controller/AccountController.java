package com.banking.BankingApp.controller;

import com.banking.BankingApp.entity.AccountEntity;
import com.banking.BankingApp.exception.AccountNotFoundException;
import com.banking.BankingApp.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController
{
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService service;

    @GetMapping("/accounts")
    public List<AccountEntity> getAccounts()
    {
        logger.info("In service of get Accounts in Class Account Controller");
        return service.getAccounts();
    }

    @GetMapping("/accounts/{accId}")
    public AccountEntity getAccountByAccountId(@PathVariable int accId) throws AccountNotFoundException
    {
        logger.info("In service of get Account by Account Id in Class Account Controller");
        return service.getAccountByAccountId(accId);
    }

    @GetMapping("/accounts/accountnumber/{accountNumber}")
    public AccountEntity getAccountByAccountNumber(@PathVariable int accountNumber) throws AccountNotFoundException {
        logger.info("In service of get Account by Account Number in Class Account Controller");
        return service.getAccountByAccountNumber(accountNumber);
    }

    @PostMapping("/account")
    public void addAccount(@RequestBody AccountEntity account)
    {
        logger.info("In service of Account Add New Account in Class Account Controller");
        System.out.println(account);
        service.addAccount(account);
    }

    @PutMapping("/accounts/{accountNumber}/depositAmount/{amount}")
    public void deposit(@PathVariable int accountNumber, @PathVariable double amount) throws AccountNotFoundException {
        logger.info("In service of Accounts Deposit Amount in Class Account Controller");
        service.deposit(amount, accountNumber);
    }

    @PutMapping("/accounts/{accountNumber}/withdrawalAmount/{amount}")
    public void withdraw(@PathVariable int accountNumber, @PathVariable double amount) throws AccountNotFoundException {
        logger.info("In service of Accounts withdraw Amount in Class Account Controller");
        service.withdraw(amount, accountNumber);
    }

    @PutMapping("/accounts/{accountNumber}/transferAmount/{amount}/accountNumber/{otherAccountNumber}")
    public AccountEntity transfer(@PathVariable int accountNumber, @PathVariable double amount, @PathVariable int otherAccountNumber) throws AccountNotFoundException {
        logger.info("In service of Accounts Transfer Amount in Class Account Controller");
            return service.transfer(amount, accountNumber, otherAccountNumber);
    }

    @DeleteMapping("/accounts/{accountNumber}/delete")
    public void deleteByAccountNumber (@PathVariable int accountNumber) throws AccountNotFoundException {
        logger.info("In service of Accounts Delete account by account number in Class Account Controller");
        service.deleteByAccountNumber(accountNumber);
    }

    @DeleteMapping("/accounts/{accountId}/deleteid")
    public void deleteByAccountId (@PathVariable int accountId) throws AccountNotFoundException
    {
        logger.info("In service of Accounts Delete account by account Id in Class Account Controller");
        service.deleteByAccountId(accountId);
    }

    @GetMapping("/accounts/{accountNumber}/balance")
    public String balance (@PathVariable int accountNumber) throws AccountNotFoundException {
        logger.info("In service of Accounts see balance by account number in Class Account Controller");
        return service.balance(accountNumber);
    }

}
