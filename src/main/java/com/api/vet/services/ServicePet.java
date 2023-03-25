package com.api.vet.services;


import com.api.vet.model.Client;
import com.api.vet.model.Pet;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ServicePet {
    Pet savePet(Pet pet);
    List<Pet> getPetsByClientId(Long clientId);

}
