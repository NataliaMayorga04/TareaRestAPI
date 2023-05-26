package com.api.vet.controller;

import com.api.vet.controller.DTO.ClientDTO;
import com.api.vet.model.Client;
import com.api.vet.services.client.ServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/client")

public class ClientController {

    private final ServiceClient serviceClient;

    @PostMapping(value = "/postClient")
    public ResponseEntity saveClient(@RequestBody ClientDTO clientDTO) {
        try{
            Client client = new Client(clientDTO.getId(), clientDTO.getAddress(), clientDTO.getName(), clientDTO.getDateCreated());
            return new ResponseEntity(serviceClient.saveClient(client), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> obtainClient(@PathVariable("id") Long idClient) {
        Optional<Client> client = serviceClient.obtainClient(idClient);
        if (client.isPresent()) {
            ClientDTO responseDTO = convertToClientResponseDTO(client.get());
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Helper method to convert Client entity to ClientResponseDTO
    private ClientDTO convertToClientResponseDTO(Client client) {
        ClientDTO responseDTO = new ClientDTO();
        responseDTO.setId(client.getId());
        responseDTO.setAddress(client.getAddress());
        responseDTO.setName(client.getName());
        responseDTO.setDateCreated(client.getDateCreated());
        // Set other necessary fields or relationships
        return responseDTO;
    }

    // Helper method to convert Client entity to ClientResponseDTO


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
