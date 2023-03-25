package com.api.vet.services;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.model.Reservation;
import java.util.Date;

import java.util.Optional;

public interface ServiceReservation {
    Reservation saveReservation(Reservation reservation);

    Optional<Reservation> obtainReservation(long idReservation);
}
