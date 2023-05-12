package com.api.vet.controller;

import com.api.vet.controller.DTO.ClientDTO;
import com.api.vet.model.Client;
import com.api.vet.services.client.ServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
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

     //

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
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
