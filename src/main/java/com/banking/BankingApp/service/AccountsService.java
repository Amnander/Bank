package com.banking.BankingApp.service;

import com.banking.BankingApp.model.BankAccount;
import com.banking.BankingApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AccountsService
{
    @Autowired
    AccountRepository accountRepository;

    List<BankAccount> bankAccounts = Arrays.asList(
            new BankAccount(101,"Aman",12345, 2000.00),
            new BankAccount(102,"Smith",12346, 1000.00),
            new BankAccount(103,"John",10001, 4000.00),
            new BankAccount(104,"Anna",10089, 3000.00)
    );

    public List<BankAccount> getAccounts()
    {
        return bankAccounts;
    }

    public BankAccount getAccountByAccountId(int accId)
    {
        return bankAccounts.stream().filter(bankAccount ->
                bankAccount.getAccountId()== accId).findFirst().orElse(null);
    }

    public double deposit(double amount, int accountNumber)
    {
        BankAccount bankAccount = null;
        double balanceAfterDeposit = 0;
        if(accountNumber > 0) {
            bankAccount = bankAccounts.stream().filter(acc ->
                    acc.getAccountNumber()== accountNumber).findFirst().orElse(null);
        }
        if(bankAccount != null) {
            balanceAfterDeposit = bankAccount.getAccountBalance() + amount;
            bankAccount.setAccountBalance(balanceAfterDeposit);
        }

        return bankAccount.getAccountBalance();
    }

    public double withdraw(double amount, int accountNumber)
    {
        BankAccount bankAccount = null;
        double balanceAfterWithdrawal = 0;
        if(accountNumber > 0) {
            bankAccount = bankAccounts.stream().filter(acc ->
                    acc.getAccountNumber()== accountNumber).findFirst().orElse(null);
        }
        if(bankAccount != null) {
            balanceAfterWithdrawal = bankAccount.getAccountBalance() - amount;
            bankAccount.setAccountBalance(balanceAfterWithdrawal);
        }

        return bankAccount.getAccountBalance();
    }

    public void printBalance(int accountNumber)
    {
        BankAccount bankAccount = null;
        if(accountNumber > 0) {
            bankAccount = bankAccounts.stream().filter(acc ->
                    acc.getAccountNumber()== accountNumber).findFirst().orElse(null);
        }
        System.out.println("The current account balance is: " + bankAccount.getAccountBalance());
    }

    public double transfer(double amount, int accountNumber, int otherAccountNumber) {
        BankAccount bankAccount = null;
        BankAccount otherBankAccount = null;
        double balanceAfterDeposit = 0;
        double balanceAfterWithdrawal = 0;

        if(accountNumber > 0 && otherAccountNumber > 0) {
            bankAccount = bankAccounts.stream().filter(acc ->
                    acc.getAccountNumber()== accountNumber).findFirst().orElse(null);
            otherBankAccount = bankAccounts.stream().filter(acc ->
                acc.getAccountNumber()== otherAccountNumber).findFirst().orElse(null);
        }
        if(bankAccount != null && otherBankAccount != null) {
            balanceAfterDeposit = otherBankAccount.getAccountBalance() + amount;
            otherBankAccount.setAccountBalance(balanceAfterDeposit);
            balanceAfterWithdrawal = bankAccount.getAccountBalance() - amount;
            bankAccount.setAccountBalance(balanceAfterWithdrawal);
        }

        return bankAccount.getAccountBalance();
    }
}
