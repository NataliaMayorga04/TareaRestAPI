package com.api.vet.services;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.model.Reservation;
import com.api.vet.repository.ClientRepository;
import com.api.vet.repository.PetRepository;
import com.api.vet.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceReservationImp implements ServiceReservation{

    private final ReservationRepository repositoryReservation;
    private final PetRepository repositoryPet;
    /*@Override
    public Reservation saveReservation(Reservation reservation) {
        // Check if the client already has a reservation for the same pet on the same day
        return repositoryReservation.save(reservation);
    }*/
    @Override
    public Reservation saveReservation(Reservation reservation) {
        Long clientId = reservation.getClient().getId();
        Date reservationDate = reservation.getReservationDate();

        // Check if the client has any pets scheduled for the given date
        List<Pet> pets = repositoryPet.findByClientId(clientId);
        boolean hasPetScheduled = pets.stream()
                .anyMatch(pet -> reservationDate.equals(pet.getDateCreated()));

        if (hasPetScheduled) {
            throw new RuntimeException("Cannot make a reservation for this client as they already have a pet scheduled for the given date");
        }

        return repositoryReservation.save(reservation);
    }

    @Override
    public Optional<Reservation> obtainReservation(long idReservation) {
        return repositoryReservation.findById(idReservation);
    }

}
