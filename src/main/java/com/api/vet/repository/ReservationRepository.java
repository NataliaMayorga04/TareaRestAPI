package com.api.vet.repository;

import com.api.vet.model.Client;

import com.api.vet.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByClientAndReservationDate(Client client, Date reservationDate);
}
