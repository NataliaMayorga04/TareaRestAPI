package com.api.vet.services.reservation;

import com.api.vet.model.Reservation;

import java.util.List;


public interface ServiceReservation {
    Reservation saveReservation(Reservation reservation);

    List<Reservation> getAllReservationsByClientId(Long clientId);

}
