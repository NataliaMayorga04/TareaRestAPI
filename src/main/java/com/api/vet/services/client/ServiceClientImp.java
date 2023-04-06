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

    @Override
    public Client clientModify(Long id, Client clientModify) {
        Client clientSerched = repositoryClient.findById(id).get();
        clientSerched.setAddress(clientModify.getAddress());
        return repositoryClient.save(clientSerched);
    }

    @Override
    public boolean deleteClient(Long id) {
        if(id != null){
            repositoryClient.deleteById(id);
            return true;
        }else{
            throw new RuntimeException("Id cannot be null");
        }

    }

}