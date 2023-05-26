package com.api.vet.controller;

import com.api.vet.controller.DTO.PetDTO;
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

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/client")

public class PetController {

    private final ServicePet servicePet;

    @PostMapping(value = "/postPet")
    public ResponseEntity savePet(@RequestBody PetDTO petDTO) {
        try{
            Pet pet = new Pet(petDTO.getId(),petDTO.getName(), petDTO.getDateCreated(), petDTO.getClient());
            return new ResponseEntity(servicePet.savePet(pet), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping(value = "/{clientId}/pets")
    public ResponseEntity<List<Pet>> getPetsByClientId(@PathVariable("clientId") Long clientId) {
        List<Pet> pets = servicePet.getPetsByClientId(clientId);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
}
