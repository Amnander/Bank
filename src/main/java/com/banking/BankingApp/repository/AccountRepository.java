package com.banking.BankingApp.repository;

import com.banking.BankingApp.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    public AccountEntity findByAccountNumber(Integer accountNumber);
}
