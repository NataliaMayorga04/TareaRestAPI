package com.api.vet.services;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.repository.ClientRepository;
import com.api.vet.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicePetImp implements ServicePet{

    private final PetRepository repositoryPet;
    @Override
    public Pet savePet(Pet pet) {
        Long clientId = pet.getClient().getId();
        List<Pet> pets = repositoryPet.findByClientId(clientId);
        if (pets.size() >= 2) {
            throw new RuntimeException("Cannot associate more than 2 pets to a client");
        }
        return repositoryPet.save(pet);
    }


    @Override
    public List<Pet> getPetsByClientId(Long clientId) {
        return repositoryPet.findByClientId(clientId);
    }

}
