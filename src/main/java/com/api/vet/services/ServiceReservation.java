package com.api.vet.services;

import com.api.vet.model.Reservation;

public interface ServiceReservation {
    Reservation saveReservation(Reservation reservation);

    Reservation getReservation(Reservation Client);
}
