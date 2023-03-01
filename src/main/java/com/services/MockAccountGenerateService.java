/* package com.services;

import com.repository.ClientRepository;
import com.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MockAccountGenerateService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountIdGenerationService accountIdGenerationService;

    public void generateAccounts() {
        Client account1 = Client.builder()
                .id(accountIdGenerationService.newAccountId())
                .balance(new BigDecimal(100))
                .name("Berkay account")
                .build();
        clientRepository.save(account1);

        Client account2 = Client.builder()
                .id(accountIdGenerationService.newAccountId())
                .balance(new BigDecimal(100))
                .name("Test account")
                .build();
    }
}*/
