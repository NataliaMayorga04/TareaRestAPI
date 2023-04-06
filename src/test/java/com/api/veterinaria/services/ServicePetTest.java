package com.api.veterinaria.services;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import com.api.vet.repository.PetRepository;
import com.api.vet.services.pet.ServicePetImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ServicePetTest {

    @InjectMocks
    private ServicePetImp petService;

    @Mock
    private PetRepository repositoryPet;

    @Test
    void Given_a_pet_when_save_then_saveInDB(){
        Client owner = new Client(456L, "Cra 8", "Luisa", new Date("18/6/23"), null);
        Pet pet = new Pet(owner, 987L, "Pepe", new Date("18/6/23"));
        Mockito.when(repositoryPet.save(pet)).thenReturn(pet);

        Pet savedPet = petService.savePet(pet);
        Mockito.verify(repositoryPet).save(pet);
        Assertions.assertNotNull(savedPet);
        Assertions.assertEquals(pet, savedPet);
    }

    @Test
    void Given_a_pet_and_client_with_moreThan2Pets_when_savePet_then_return_RunTimeException(){
        Client owner = new Client(789L, "Cll 64", "Pedro", new Date("24/7/23"));
        Pet savedPet1 = new Pet(owner, 321L, "Max", new Date("20/6/23"));
        Pet savedPet2 = new Pet(owner, 975L, "Garfield", new Date("24/6/23"));
        Mockito.when(repositoryPet.findByClientId(owner.getId())).thenReturn(Arrays.asList(savedPet1, savedPet2));

        Pet newPet = new Pet(owner, 654L, "Fluffy", new Date("24/7/23"));

        Assertions.assertThrows(RuntimeException.class, () -> {
            petService.savePet(newPet);
        });
        Mockito.verify(repositoryPet).findByClientId(789L);
    }

    @Test
    void Given_a_clientID_when_search_petsByClientID_then_return_listOfPets(){
        Client owner = new Client(674L, "Cll 48", "Sandra", new Date("18/5/23"));
        Pet savedPet1 = new Pet(owner, 311L, "Scooby", new Date("20/7/23"));
        Pet savedPet2 = new Pet(owner, 845L, "Fiona", new Date("12/8/23"));
        List<Pet> expectedPets = Arrays.asList(savedPet1, savedPet2);
        Mockito.when(repositoryPet.findByClientId(owner.getId())).thenReturn(expectedPets);

        List<Pet> savedPets = petService.getPetsByClientId(owner.getId());
        Assertions.assertEquals(expectedPets, savedPets);
        Mockito.verify(repositoryPet).findByClientId(owner.getId());
    }
}
