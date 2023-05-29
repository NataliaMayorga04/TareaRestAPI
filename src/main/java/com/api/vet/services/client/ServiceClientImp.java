package com.api.vet.services.client;

import com.api.vet.model.Client;
import com.api.vet.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceClientImp implements ServiceClient {

    private final ClientRepository repositoryClient;

    @Override
    public Client saveClient(Client client) {
        return repositoryClient.save(client);
    }

    @Override
    public Optional<Client> obtainClient(long idClient) {
        return repositoryClient.findById(idClient);
    }


}