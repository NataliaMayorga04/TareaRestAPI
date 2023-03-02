package com.api.vet.services;

import com.api.vet.model.Client;
import com.api.vet.model.Reservation;
import com.api.vet.repository.ClientRepository;
import com.api.vet.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceClientImp implements ServiceClient {

    private final ReservationRepository repositoryReservation;
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
    public boolean deleteClient(Long id) {

        try{
            repositoryClient.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Reservation saveReservation(Long idClient, Reservation reservation) {
        Optional<Client> optionalClient = repositoryClient.findById(idClient);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            reservation.setClient(client);
            return  repositoryReservation.save(reservation);
        }
        throw new RuntimeException("Client not found with id " + idClient);
    }

    @Override
    public List<Reservation> getAllReservations(Long idClient) {
        Optional<Client> optionalClient = repositoryClient.findById(idClient);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            return client.getReservations();
        }
        throw new RuntimeException("Client not found with id " + idClient);
    }
}
