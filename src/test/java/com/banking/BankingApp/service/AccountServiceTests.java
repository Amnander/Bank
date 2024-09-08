package com.banking.BankingApp.service;

import com.banking.BankingApp.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountServiceTests
{
    @Autowired
    public AccountRepository accountRepository;

    @Test
    public void testFindByAccountNumber()
    {
        assertNotNull(accountRepository.findByAccountNumber(1231));
    }

}
