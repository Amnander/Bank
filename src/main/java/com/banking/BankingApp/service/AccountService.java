package com.banking.BankingApp.service;

import com.banking.BankingApp.entity.AccountEntity;
import com.banking.BankingApp.model.BankAccount;
import com.banking.BankingApp.repository.AccountRepository;
import jakarta.transaction.Transactional;
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

    public AccountEntity getAccountByAccountNumber(int accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Transactional
    public void deposit(double amount, int accountNumber)
    {
        AccountEntity account = accountRepository.findByAccountNumber(accountNumber);
        double balanceAfterDeposit = account.getAccountBalance() + amount;
        account.setAccountBalance(balanceAfterDeposit);
        accountRepository.save(account);
    }

    @Transactional
    public void withdraw(double amount, int accountNumber)
    {
        AccountEntity account = accountRepository.findByAccountNumber(accountNumber);
        double balanceAfterWithdraw = account.getAccountBalance() - amount;
        account.setAccountBalance(balanceAfterWithdraw);
        accountRepository.save(account);
    }

    @Transactional
    public void addAccount(AccountEntity account)
    {
        accountRepository.save(account);
    }

    @Transactional
    public AccountEntity transfer(double amount, int accountNumber, int otherAccountNumber)
    {
        AccountEntity otherAccount = accountRepository.findByAccountNumber(otherAccountNumber);
        double balanceAfterDeposit = otherAccount.getAccountBalance() + amount;
        otherAccount.setAccountBalance(balanceAfterDeposit);
        accountRepository.save(otherAccount);

        AccountEntity account = accountRepository.findByAccountNumber(accountNumber);

        double balanceAfterTransfer = account.getAccountBalance() - amount;
        account.setAccountBalance(balanceAfterTransfer);
        return accountRepository.save(account);
    }
    @Transactional
    public void delete(int accountNumber)
    {
        AccountEntity account = accountRepository.findByAccountNumber(accountNumber);
        accountRepository.delete(account);
    }

}
