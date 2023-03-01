package com.controller;

import com.model.Client;
import com.services.ServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/client")
public class ControllerClient {
    private final ServiceClient serviceClient;

    @PostMapping
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
        boolean response = serviceClient.deleteUser(idClient);
        if (response == true) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}