package com.api.vet.services;

import com.api.vet.model.Client;
import com.api.vet.model.Reservation;
import com.api.vet.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation makeReservation(Long idClient, Reservation reservation) {
        Client client = new Client();
        client.setId(idClient);
        return reservationRepository.save(reservation);
    }
}
