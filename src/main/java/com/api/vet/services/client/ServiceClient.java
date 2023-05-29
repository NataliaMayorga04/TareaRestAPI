package com.api.vet.services.client;

import com.api.vet.model.Client;

import java.util.Optional;

public interface ServiceClient {

    Client saveClient(Client client);

    Optional<Client> obtainClient(long idClient);

}