package com.banking.BankingApp.service;

import com.banking.BankingApp.entity.AccountEntity;
import com.banking.BankingApp.model.BankAccount;
import com.banking.BankingApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AccountService
{
    @Autowired
    AccountRepository accountRepository;

    List<BankAccount> bankAccounts = Arrays.asList(new BankAccount(101,"Aman",3, 2000.00), new BankAccount(102,"Sukh",7, 1000.00));
    public List<AccountEntity> getAccounts()
    {
        return accountRepository.findAll();
    }

    public AccountEntity getAccountByAccountId(int accId)
    {
        return accountRepository.findById(accId).orElse(new AccountEntity());
    }

    public AccountEntity deposit(double amount, int accountNumber)
    {
        AccountEntity account = accountRepository.findByAccountNumber(accountNumber);
        double balanceAfterDeposit = account.getAccountBalance() + amount;
        account.setAccountBalance(balanceAfterDeposit);
        return accountRepository.save(account);
    }

    public AccountEntity withdraw(double amount, int accountNumber)
    {
        AccountEntity account = accountRepository.findByAccountNumber(accountNumber);
        double balanceAfterDeposit = account.getAccountBalance() - amount;
        account.setAccountBalance(balanceAfterDeposit);
        return accountRepository.save(account);
    }

    public AccountEntity transfer(AccountEntity account)
    {
        return accountRepository.save(account);
    }

    public void addAccount(AccountEntity account)
    {
        accountRepository.save(account);
    }
}
