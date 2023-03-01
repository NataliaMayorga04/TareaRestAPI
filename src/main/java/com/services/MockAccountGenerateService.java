package com.services;

import com.AccountRepository;
import com.h2.veterinaria.domain.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MockAccountGenerateService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountIdGenerationService accountIdGenerationService;

    public void generateAccounts() {
        Account account1 = Account.builder()
                .id(accountIdGenerationService.newAccountId())
                .balance(new BigDecimal(100))
                .name("Berkay account")
                .build();
        accountRepository.save(account1);

        Account account2 = Account.builder()
                .id(accountIdGenerationService.newAccountId())
                .balance(new BigDecimal(100))
                .name("Test account")
                .build();
    }
}
