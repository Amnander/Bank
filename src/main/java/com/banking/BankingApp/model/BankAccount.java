package com.banking.BankingApp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class BankAccount
{
    private int accountId;

    private String accountHolderName;

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
