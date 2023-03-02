package com.api.vet.services;

import com.api.vet.repository.ClientRepository;
import com.api.vet.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientQueryService {
    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> getClientById(Long Id) {
        return clientRepository.findById(Id);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

}
