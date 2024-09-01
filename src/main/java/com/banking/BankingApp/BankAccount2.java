package com.banking.BankingApp;

import org.springframework.stereotype.Component;

@Component
public class BankAccount2
{
    private double balance;

    public BankAccount2()
    {

    }

    public BankAccount2(double balance)
    {
        this.balance = balance;
    }

    public double deposit(double amount)
    {
        return balance + amount;
    }

    public double withdraw(double amount)
    {
        return balance - amount;
    }

    public void printBalance()
    {
        System.out.println("The current account balance is: " + balance);

    }

    public void transferBalance(double amount, BankAccount2 otherAccount)
    {
        balance = withdraw(amount);
        otherAccount.deposit(amount);
    }

    public double getBalance()
    {
        return balance;
    }

    }

