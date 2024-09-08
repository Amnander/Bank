package com.banking.BankingApp.service;

import com.banking.BankingApp.entity.AccountEntity;
import com.banking.BankingApp.exception.AccountNotFoundException;
import com.banking.BankingApp.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.Optional.ofNullable;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<AccountEntity> getAccounts()
    {
        return accountRepository.findAll();
    }

    public AccountEntity getAccountByAccountId(int accId) throws AccountNotFoundException
    {
        return accountRepository.findById(accId).orElseThrow(AccountNotFoundException::new);
    }

    @Transactional
    public void deposit(double amount, int accountNumber) throws AccountNotFoundException {
        AccountEntity account = getAccountByAccountNumber(accountNumber);
        double balanceAfterDeposit = account.getAccountBalance() + amount;
        account.setAccountBalance(balanceAfterDeposit);
        accountRepository.save(account);
    }

    @Transactional
    public void withdraw(double amount, int accountNumber) throws AccountNotFoundException {
        AccountEntity account = getAccountByAccountNumber(accountNumber);
        double balanceAfterWithdraw = account.getAccountBalance() - amount;
        account.setAccountBalance(balanceAfterWithdraw);
        accountRepository.save(account);
        if (account.getAccountBalance()<amount)
        {
            throw new RuntimeException("Insufficient Funds");
        }

    }

    @Transactional
    public void addAccount(AccountEntity account) {
        accountRepository.save(account);
    }

    @Transactional
    public AccountEntity transfer(double amount, int accountNumber, int otherAccountNumber) throws AccountNotFoundException {
        AccountEntity account = getAccountByAccountNumber(accountNumber);
        AccountEntity otherAccount = getAccountByAccountNumber(otherAccountNumber);
        if (account.getAccountBalance()<amount)
        {
            throw new RuntimeException("Insufficient Funds");
        }

        double balanceAfterDeposit = otherAccount.getAccountBalance() + amount;
        otherAccount.setAccountBalance(balanceAfterDeposit);
        accountRepository.save(otherAccount);
        double balanceAfterTransfer = account.getAccountBalance() - amount;
        account.setAccountBalance(balanceAfterTransfer);
        return accountRepository.save(account);

    }

    @Transactional
    public void deleteByAccountNumber(int accountNumber) throws AccountNotFoundException {
        AccountEntity account = ofNullable(accountRepository.findByAccountNumber(accountNumber)).orElseThrow(AccountNotFoundException::new);
        accountRepository.delete(account);
    }

    @Transactional
    public void deleteByAccountId(int AccountId) throws AccountNotFoundException {
        AccountEntity account = accountRepository.findById(AccountId).orElseThrow(AccountNotFoundException::new);
        accountRepository.delete(account);
    }

    public String balance(int accountNumber) throws AccountNotFoundException {
        AccountEntity account = getAccountByAccountNumber(accountNumber);
        double balance = account.getAccountBalance();
        return "Your current account balance is: " + balance;
    }

    public AccountEntity getAccountByAccountNumber(int accountNumber) throws AccountNotFoundException
    {
        return ofNullable(accountRepository.findByAccountNumber(accountNumber)).orElseThrow(AccountNotFoundException::new);
    }
}


