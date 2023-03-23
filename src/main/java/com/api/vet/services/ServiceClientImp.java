package com.api.vet.services;

import com.api.vet.model.Client;
import com.api.vet.model.Reservation;
import com.api.vet.repository.ClientRepository;
import com.api.vet.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
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
    public Reservation saveReservation(Reservation reservation) {
        return repositoryReservation.save(reservation);
    }

    @Override
    public Optional<List<Reservation>> getAllReservations(Long clientID) {
        return repositoryReservation.getReservation(clientID);
    }

    @Override
    public Optional<List<Reservation>> getReservationByDate(Date reservationDate) {
        return repositoryReservation.getReservation(reservationDate);
    }



}