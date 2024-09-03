package com.banking.BankingApp.service;

import com.banking.BankingApp.exception.AccountNotFoundException;
import com.banking.BankingApp.model.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class AccountsService
{

    private static final Logger logger = LogManager.getLogger(AccountsService.class);
    List<BankAccount> bankAccounts = Arrays.asList(
            new BankAccount(101,"Aman",123411, 2000.00),
            new BankAccount(102,"Smith",123422, 1000.00),
            new BankAccount(103,"John",123433, 4000.00),
            new BankAccount(104,"Anna",123444, 3000.00)
    );

    public Double deposit(double amount, int accountNumber) throws AccountNotFoundException
    {
        logger.info("In deposit method");
        BankAccount bankAccount = null;
        double balanceAfterDeposit = 0;
        if(accountNumber > 0) {
            bankAccount = bankAccounts.stream().filter(acc ->
                    acc.getAccountNumber()== accountNumber).findFirst().orElseThrow(AccountNotFoundException::new);
        }
        if(bankAccount != null) {
            logger.info("Bank account exists");
            balanceAfterDeposit = bankAccount.getAccountBalance() + amount;
            bankAccount.setAccountBalance(balanceAfterDeposit);
            return bankAccount.getAccountBalance();
        }
        return null;
    }

    public Double withdraw(double amount, int accountNumber) throws AccountNotFoundException
    {
        logger.info("In withdraw method");
        BankAccount bankAccount = null;
        double balanceAfterWithdrawal = 0;
        if(accountNumber > 0)
        {
            bankAccount = bankAccounts.stream().filter(acc ->
                    acc.getAccountNumber()== accountNumber).findFirst().orElseThrow(AccountNotFoundException::new);
        }
        if(bankAccount != null) {
            logger.info("Bank account exists");
            double accountBalance = bankAccount.getAccountBalance();
            if (amount > accountBalance)
            {
                System.out.println("You don't have enough balance");
                return null;
            }
            else
            {
                balanceAfterWithdrawal = bankAccount.getAccountBalance() - amount;
                bankAccount.setAccountBalance(balanceAfterWithdrawal);
            }
            return bankAccount.getAccountBalance();
        }
            return null;

    }

    public void printBalance(int accountNumber)
    {
        logger.info("In printBalance method");
        BankAccount bankAccount = null;
        if(accountNumber > 0)
        {
            bankAccount = bankAccounts.stream().filter(acc ->
                    acc.getAccountNumber()== accountNumber).findFirst().orElse(null);
        }
        if (bankAccount != null)
        {
            logger.info("Bank account exists");
            System.out.println("The current account balance is: " + bankAccount.getAccountBalance());
        }
    }

    public Double transfer(double amount, int accountNumber, int otherAccountNumber) throws AccountNotFoundException
    {
        logger.info("In transfer method");
        BankAccount bankAccount = null;
        BankAccount otherBankAccount = null;
        double balanceAfterDeposit = 0;
        double balanceAfterWithdrawal = 0;

        if(accountNumber > 0 && otherAccountNumber > 0) {
            bankAccount = bankAccounts.stream().filter(acc ->
                    acc.getAccountNumber()== accountNumber).findFirst().orElseThrow(AccountNotFoundException::new);
            otherBankAccount = bankAccounts.stream().filter(acc ->
                acc.getAccountNumber()== otherAccountNumber).findFirst().orElseThrow(AccountNotFoundException::new);
        }
        if(bankAccount != null && otherBankAccount != null) //null check
        {
            logger.info("Both Accounts Exist");
            balanceAfterDeposit = otherBankAccount.getAccountBalance() + amount;
            otherBankAccount.setAccountBalance(balanceAfterDeposit);
            balanceAfterWithdrawal = bankAccount.getAccountBalance() - amount;
            bankAccount.setAccountBalance(balanceAfterWithdrawal);

            double accountBalance = bankAccount.getAccountBalance();
            if (amount > accountBalance)
            {
                logger.info("Bank account exists");
                System.out.println("You don't have enough balance to transfer");
                return null;
            }
            else
            {
                balanceAfterWithdrawal = bankAccount.getAccountBalance() - amount;
                bankAccount.setAccountBalance(balanceAfterWithdrawal);
            }

            return bankAccount.getAccountBalance();
        }


        return null;

    }
}
