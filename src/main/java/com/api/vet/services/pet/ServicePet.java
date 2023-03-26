package com.api.vet.services.pet;

import com.api.vet.model.Pet;

import java.util.List;

public interface ServicePet {
    Pet savePet(Pet pet);

    List<Pet> getPetsByClientId(Long clientId);

}
