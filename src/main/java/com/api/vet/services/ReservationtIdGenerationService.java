package com.api.vet.services;

import org.springframework.stereotype.Service;

@Service
public class ReservationtIdGenerationService {
    public Long newReservationId() {
        return System.nanoTime();
    }
}
