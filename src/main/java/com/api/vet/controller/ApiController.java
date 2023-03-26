package com.api.vet.controller;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.model.Reservation;
import com.api.vet.services.client.ServiceClient;
import com.api.vet.services.pet.ServicePet;
import com.api.vet.services.reservation.ServiceReservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/client")

public class ApiController {


    private final ServiceClient serviceClient;
    private final ServicePet servicePet;
    private final ServiceReservation serviceReservation;

    @PostMapping(value = "/postClient")
    public ResponseEntity saveClient(@RequestBody Client client) {
        return new ResponseEntity(serviceClient.saveClient(client), HttpStatus.CREATED);
    }

    @PostMapping(value = "/postPet")
    public ResponseEntity savePet(@RequestBody Pet pet) {
        return new ResponseEntity(servicePet.savePet(pet), HttpStatus.CREATED);
    }

    @PostMapping(value = "/postReservation")
    public ResponseEntity saveReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity(serviceReservation.saveReservation(reservation), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity obtainClient(@PathVariable("id") Long idClient) {
        return new ResponseEntity(serviceClient.obtainClient(idClient), HttpStatus.OK);
    }

    @GetMapping(value = "/{clientId}/pets")
    public ResponseEntity<List<Pet>> getPetsByClientId(@PathVariable("clientId") Long clientId) {
        List<Pet> pets = servicePet.getPetsByClientId(clientId);
        return new ResponseEntity<>(pets, HttpStatus.OK);
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
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


}

