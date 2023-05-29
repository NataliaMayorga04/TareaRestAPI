package com.api.vet.services.reservation;

import com.api.vet.model.Client;
import com.api.vet.model.Reservation;
import com.api.vet.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
public class ServiceReservationImp implements ServiceReservation {

    private final ReservationRepository repositoryReservation;


    @Override
    public Reservation saveReservation(Reservation reservation) {
        Client client = reservation.getClient();
        Date reservationDate = reservation.getReservationDate();

        if (repositoryReservation.existsByClientAndReservationDate(client, reservationDate)) {
            throw new RuntimeException("A reservation already exists for this client and date.");
        }

        return repositoryReservation.save(reservation);

    }

    @Override
    public List<Reservation> getAllReservationsByClientId(Long clientId) {
        // Implement the logic to retrieve reservations by client ID
        // using the ReservationRepository or any other necessary dependencies

        // Example implementation:
        return repositoryReservation.findByClientId(clientId);
    }


}
