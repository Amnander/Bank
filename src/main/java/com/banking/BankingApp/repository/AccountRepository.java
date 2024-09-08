package com.banking.BankingApp.repository;

import com.banking.BankingApp.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AccountRepository extends JpaRepository<AccountEntity, Integer>
{
    public AccountEntity findByAccountNumber(Integer accountNumber);
}
