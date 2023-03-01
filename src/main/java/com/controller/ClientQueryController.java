package com.controller;

import com.model.Client;
import com.services.ClientQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/client")
public class ClientQueryController {
    private final ClientQueryService clientQueryService;

    public ClientQueryController(ClientQueryService clientQueryService) {
        this.clientQueryService = clientQueryService;
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Client> getId(@PathVariable(value = "accountId") Long Id) {
        Optional<Client> accountOpt = clientQueryService.getClientById(Id);
        return accountOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public List<Client> getClients() {
        return clientQueryService.getClients();
    }

}
