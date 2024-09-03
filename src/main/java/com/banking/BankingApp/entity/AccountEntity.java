package com.banking.BankingApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountEntity
{
    @Id //unique by default
    private int accountId;

    private String accountHolderName;

    @Column(unique=true) //for unique values
    private int accountNumber;

    private double accountBalance;

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
    public String toString()
    {
        return "Account{" +
                "accountId=" + accountId +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof AccountEntity account)) return false;
        return getAccountId() == account.getAccountId() && getAccountNumber() == account.getAccountNumber() && Double.compare(getAccountBalance(), account.getAccountBalance()) == 0 && Objects.equals(getAccountHolderName(), account.getAccountHolderName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getAccountId(), getAccountHolderName(), getAccountNumber(), getAccountBalance());
    }
}
