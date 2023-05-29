package com.api.vet.controller;
import com.api.vet.controller.DTO.ClientDTO;
import com.api.vet.controller.DTO.ReservationDTO;
import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.services.reservation.ServiceReservation;
import com.api.vet.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/client")

public class ReservationController {

    private final ServiceReservation serviceReservation;

    @PostMapping(value = "/postReservation")
    public ResponseEntity saveReservation(@RequestBody ReservationDTO reservationDTO) {
        try{
            Reservation reservation = new Reservation(reservationDTO.getIdReserva(), reservationDTO.getReservationDate(), reservationDTO.getClient(), reservationDTO.getPet());
            return new ResponseEntity(serviceReservation.saveReservation(reservation), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    /*@GetMapping(value = "/{clientId}/reservations")
    public ResponseEntity<List<Reservation>> getAllReservationsByClientId(@PathVariable Long clientId) {
        List<Reservation> reservations= serviceReservation.getAllReservationsByClientId(clientId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }*/

    @GetMapping(value = "/{clientId}/reservations")
    public ResponseEntity<List<ReservationDTO>> getAllReservationsByClientId(@PathVariable Long clientId) {
        try {
            List<Reservation> reservations = serviceReservation.getAllReservationsByClientId(clientId);

            // Map entity objects to DTOs
            List<ReservationDTO> reservationDTOs = new ArrayList<>();
            for (Reservation reservation : reservations) {
                ReservationDTO reservationDTO = new ReservationDTO();
                reservationDTO.setIdReserva(reservation.getIdReserva());
                reservationDTO.setReservationDate(reservation.getReservationDate());
                // set other fields as needed
                reservationDTOs.add(reservationDTO);
            }

            return new ResponseEntity<>(reservationDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
