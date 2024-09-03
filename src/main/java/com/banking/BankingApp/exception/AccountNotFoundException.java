package com.banking.BankingApp.exception;

public class AccountNotFoundException extends Exception
{   //Custom Exception class
    public AccountNotFoundException()
    {
        super("This account does not exist");
    }
}
