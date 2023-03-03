package com.api.vet.repository;

import com.api.vet.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT reserva FROM Reservation reserva WHERE reserva.clientID = :clientID ")
    Optional <List<Reservation> >getReservation(@Param("clientID") Long clientID);

    @Query("SELECT reserva FROM Reservation reserva WHERE reserva.reservationDate = :reservationDate ")
    Optional <List<Reservation> >getReservation(@Param("reservationDate") Date reservationDate);

}