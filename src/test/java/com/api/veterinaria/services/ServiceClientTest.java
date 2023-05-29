package com.api.veterinaria.services;

import com.api.vet.model.Client;
import com.api.vet.repository.ClientRepository;
import com.api.vet.services.client.ServiceClientImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ServiceClientTest {

    @InjectMocks
    private ServiceClientImp clientService;

    @Mock
    private ClientRepository repositoryClient;


    @Test
    void Given_a_client_when_save_then_saveInDB(){
        Client client = new Client(456L, "Cra 8", "Luisa", new Date("18/6/23"));
        Mockito.when(repositoryClient.save(client)).thenReturn(client);

        Client savedClient = clientService.saveClient(client);
        Mockito.verify(repositoryClient).save(client);
        Assertions.assertNotNull(savedClient);
        Assertions.assertEquals("Luisa", savedClient.getName());
        Assertions.assertEquals(456L, savedClient.getId());
    }

    @Test
    void Given_a_clientID_when_search_clientByID_then_return_client(){
        Client client = new Client(789L, "Cll 64", "Pedro", new Date("24/7/23"));
        Mockito.when(repositoryClient.findById(789L)).thenReturn(java.util.Optional.of(client));

        Optional<Client> obtainedClient = clientService.obtainClient(789L);
        Assertions.assertEquals(client, obtainedClient.get());
        Mockito.verify(repositoryClient).findById(789L);
    }







}
