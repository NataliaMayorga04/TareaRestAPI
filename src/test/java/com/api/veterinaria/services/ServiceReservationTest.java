package com.api.veterinaria.services;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.model.Reservation;
import com.api.vet.repository.ReservationRepository;
import com.api.vet.services.reservation.ServiceReservationImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class ServiceReservationTest {

    @InjectMocks
    private ServiceReservationImp reservationService;

    @Mock
    private ReservationRepository repositoryReservation;

    @Test
    void Given_a_reservation_when_save_then_saveInDB(){
        Client client = new Client(853L, "Cra 94", "Fernando", new Date("8/3/23"));
        Reservation reservation = new Reservation(client, 651L, new Date("16/6/23"), new Pet(client, 323L, "Tobias", new Date("15/6/23")));
        Mockito.when(repositoryReservation.save(reservation)).thenReturn(reservation);

        Reservation savedReservation = reservationService.saveReservation(reservation);
        Mockito.verify(repositoryReservation).save(reservation);
        Assertions.assertNotNull(savedReservation);
        Assertions.assertEquals(reservation, savedReservation);
    }

    @Test
    void Given_a_reservation_with_previousSame_client_and_reservationDate_when_save_then_return_RunTimeException(){
        Client client = new Client(114L, "Cra 63", "Patricia", new Date("12/12/23"));
        Reservation expectedReservation = new Reservation(client, 682L, new Date("18/12/23"), new Pet(client, 321L, "Amapola", new Date("15/12/23")));
        Mockito.when(repositoryReservation.existsByClientAndReservationDate(client, expectedReservation.getReservationDate())).thenReturn(true);

        Reservation newReservation = new Reservation(client, 572L, new Date("18/12/23"), new Pet(client, 322L, "Lola", new Date("13/12/23")));

        Assertions.assertThrows(RuntimeException.class, () -> {
            reservationService.saveReservation(newReservation);
        });
        Mockito.verify(repositoryReservation).existsByClientAndReservationDate(client, expectedReservation.getReservationDate());
    }

}
