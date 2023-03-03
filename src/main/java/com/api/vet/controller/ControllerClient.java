package com.api.vet.controller;
import com.api.vet.controller.DTO.ReservationDTO;
import com.api.vet.model.Client;
import com.api.vet.model.Reservation;
import com.api.vet.services.ServiceClient;
import com.api.vet.services.ServicePostLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/client")
public class ControllerClient {

    private final ServicePostLimiter postLimiter = new ServicePostLimiter();
    private final ServiceClient serviceClient;

    @PostMapping(value = "/postClient")
    public ResponseEntity saveClient(@RequestBody Client client) {
        return new ResponseEntity(serviceClient.saveClient(client), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity obtainClient(@PathVariable("id") Long idClient) {
        return new ResponseEntity(serviceClient.obtainClient(idClient), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity modifyClient(@PathVariable("id") Long idClient, @RequestBody Client client) {
        return new ResponseEntity(serviceClient.clientModify(idClient, client), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long idClient, @RequestBody Client client) {
        boolean response = serviceClient.deleteClient(idClient);
        if (response == true) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/{id}/reservation")
    public ResponseEntity saveReservation(@PathVariable("id") Long idClient, @RequestBody ReservationDTO reservationDTO)
    {
        if (!ServicePostLimiter.increment()) {
            return new ResponseEntity("You have reached the maximum number of posts.", HttpStatus.BAD_REQUEST);
        }

        Reservation reservation = new Reservation(reservationDTO.getIdReserva(),reservationDTO.getPetName(),
                reservationDTO.getReservationDate(), reservationDTO.getNote(),reservationDTO.getClientID());
        return new ResponseEntity(serviceClient.saveReservation(reservation), HttpStatus.CREATED);
    }


    @GetMapping(value = "/{clientID}/reservations")
    public ResponseEntity getAllReservations(@PathVariable("clientID") Long clientID) {
        return new ResponseEntity(serviceClient.getAllReservations(clientID), HttpStatus.OK);
    }
}

  /*  @GetMapping(value = "/{clientID}/reservations")
    public ResponseEntity getAllReservations(@PathVariable("clientID") Long clientId) {
        return new ResponseEntity(serviceClient.getAllReservations(clientId), HttpStatus.OK);
    }
}*/