package com.api.vet.controller;
import com.api.vet.services.reservation.ServiceReservation;
import com.api.vet.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/client")

public class ReservationController {

    private final ServiceReservation serviceReservation;

    @PostMapping(value = "/postReservation")
    public ResponseEntity saveReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity(serviceReservation.saveReservation(reservation), HttpStatus.CREATED);
    }

}
