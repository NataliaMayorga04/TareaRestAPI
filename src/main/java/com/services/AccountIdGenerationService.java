package com.services;

import org.springframework.stereotype.Service;

@Service
public class AccountIdGenerationService {
    public Long newAccountId() {
        return System.nanoTime();
    }
}
