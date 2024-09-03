package com.banking.BankingApp.model;
import org.hibernate.dialect.Dialect;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BankAccount
{
    private int accountId;

    private String accountHolderName;

    private int accountNumber;

    private double accountBalance;

    public BankAccount(int accountId, String accountHolderName, int accountNumber, double accountBalance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public BankAccount() {
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount bankAccount)) return false;
        return getAccountId() == bankAccount.getAccountId() && getAccountNumber() == bankAccount.getAccountNumber() && Double.compare(getAccountBalance(), bankAccount.getAccountBalance()) == 0 && Objects.equals(getAccountHolderName(), bankAccount.getAccountHolderName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId(), getAccountHolderName(), getAccountNumber(), getAccountBalance());
    }
}
