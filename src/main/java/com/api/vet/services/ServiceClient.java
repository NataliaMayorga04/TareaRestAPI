package com.api.vet.services;
import com.api.vet.model.Client;
import com.api.vet.model.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ServiceClient {
    Client saveClient(Client client);

    Optional<Client> obtainClient(long idClient);

    Client clientModify(Long id, Client clientModify);

    boolean deleteClient(Long id);

    Reservation saveReservation(Reservation reservation);
    Optional <List<Reservation>> getAllReservations(Long clientID);

    Optional<List<Reservation>> getReservationByDate(Date reservationDate);
}
    /*Optional<Reservation> getAllReservations(Long idClient); */