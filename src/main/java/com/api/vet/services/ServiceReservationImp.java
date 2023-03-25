package com.api.vet.services;

import com.api.vet.model.Client;
import com.api.vet.model.Reservation;
import com.api.vet.repository.ClientRepository;
import com.api.vet.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceReservationImp implements ServiceReservation{

    private final ReservationRepository repositoryReservation;
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return repositoryReservation.save(reservation);
    }
    @Override
    public Optional<Reservation> obtainReservation(long idReservation) {
        return repositoryReservation.findById(idReservation);
    }

}
