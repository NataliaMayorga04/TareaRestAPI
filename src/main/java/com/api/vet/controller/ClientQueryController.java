package com.api.vet.controller;

import com.api.vet.model.Client;
import com.api.vet.services.ClientQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
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

    @GetMapping("")
    public List<Client> getClients() {
        return clientQueryService.getClients();
    }

}
