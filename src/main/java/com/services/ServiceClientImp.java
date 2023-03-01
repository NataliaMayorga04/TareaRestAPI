package com.services;

import com.model.Client;
import com.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceClientImp implements ServiceClient {

    private  final ClientRepository repositoryClient;
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
        clientSerched.setPetName(clientModify.getPetName());
        return repositoryClient.save(clientSerched);
    }
    @Override
    public boolean deleteUser(Long id) {

        try{
            repositoryClient.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
