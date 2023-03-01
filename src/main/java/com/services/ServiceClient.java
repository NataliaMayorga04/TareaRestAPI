package com.services;
import com.model.Client;

import java.util.Optional;

public interface ServiceClient {
    Client saveClient(Client client);

    Optional<Client> obtainClient(long idClient);

    Client clientModify(Long id, Client clientModify);

    boolean deleteUser(Long id);
}
