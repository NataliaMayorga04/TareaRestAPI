package com.api.veterinaria.integration.controller;

import com.api.vet.VetApplication;
import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.model.Reservation;
import com.api.veterinaria.AbstractTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VetApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    private static final String PATH_CLIENT = "/client/postClient";
    private static final String PATH_CLIENT_BY_ID = "/client";
    private static final String PATH_PET = "/client/postPet";
    private static final String PATH_RESERVATION = "/client/postReservation";

    @Test
    public void Given_a_client_When_call_save_client_then_saveClient() {
        Client client = new Client(473L, "Cll 56", "Carla", new Date("12/6/23"));

        ResponseEntity<Client> clientEntity = restTemplate.postForEntity(PATH_CLIENT, client, Client.class);
        assertEquals(473L, clientEntity.getBody().getId());
    }

    /*
    @Test
    public void Given_a_reservation_When_call_save_reservation_then_saveReservation() {
        Client client = new Client(473L, "Cll 56", "Carla", new Date("12/6/23"), null);
        Pet pet = new Pet(client, 657L, "Max", new Date("18/6/23"));
        Reservation reservation = new Reservation(client, 233L, new Date("20/6/23"), pet);

        ResponseEntity<Reservation> reservationEntity = restTemplate.postForEntity(PATH_RESERVATION, reservation, Reservation.class);
        assertEquals(233L, reservationEntity.getBody().getIdReserva());
    }
    */

    /*
    @Test
    public void Given_a_pet_When_call_save_pet_then_savePet() {
        Client client = new Client(473L, "Cll 56", "Carla", new Date("12/6/23"), null);
        Pet pet = new Pet(client, 657L, "Max", new Date("18/6/23"));

        ResponseEntity<Pet> petEntity = restTemplate.postForEntity(PATH_PET, pet, Pet.class);
        assertEquals(657L, petEntity.getBody().getId());
    }
    */

    /*
    @Test
    public void Given_a_clientID_when_search_a_clientByID_then_return_client(){
        Client client = new Client(123L, "Cll 9", "Carlos", new Date("12/8/23"));

        ResponseEntity<Client> clientEntity = restTemplate.getForEntity(PATH_CLIENT_BY_ID + 123L, Client.class);
        assertEquals("Carlos", clientEntity.getBody().getName());
    }
    */


}
