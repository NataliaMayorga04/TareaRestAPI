package com.api.vet.services;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.model.Reservation;
import com.api.vet.repository.ClientRepository;
import com.api.vet.repository.PetRepository;
import com.api.vet.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ServiceReservationImp implements ServiceReservation{

    private final ReservationRepository repositoryReservation;
    private final PetRepository repositoryPet;
    private final ServicePet servicePet;


    @Override
    public Reservation saveReservation(Reservation reservation) {
        Client client = reservation.getClient();
        Date reservationDate = reservation.getReservationDate();

        // Check if a reservation already exists for this client and date
        if (repositoryReservation.existsByClientAndReservationDate(reservation.getClient(), reservation.getReservationDate())) {
            throw new RuntimeException("A reservation already exists for this client and date.");
        }

        // If a reservation does not already exist, save the new reservation
        return repositoryReservation.save(reservation);

    }

    @Override
    public Optional<Reservation> obtainReservation(long idReservation) {
        return repositoryReservation.findById(idReservation);
    }


}
