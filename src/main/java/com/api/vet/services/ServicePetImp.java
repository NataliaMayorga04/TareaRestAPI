package com.api.vet.services;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.repository.ClientRepository;
import com.api.vet.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicePetImp implements ServicePet{

    private final PetRepository repositoryPet;
    @Override
    public Pet savePet(Pet pet) {
        return repositoryPet.save(pet);
    }

    @Override
    public Optional<Pet> obtainPet(long idPet) {
        return repositoryPet.findById(idPet);
    }
}
