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

    @Test
    void Given_a_clientID_when_modify_then_return_modifiedClient(){
        Client client = new Client(135L, "Cra 32", "Ana", new Date("7/4/23"));
        Client modify = new Client(135L, "Cra 74", "Ana", new Date("7/4/23"));
        Mockito.when(repositoryClient.findById(135L)).thenReturn(Optional.of(client));
        Mockito.when(repositoryClient.save(modify)).thenReturn(modify);

        Client modifiedClient = clientService.clientModify(135L, modify);
        Assertions.assertNotNull(modifiedClient);
        Assertions.assertEquals(modify, modifiedClient);
        Mockito.verify(repositoryClient).findById(135L);
        Mockito.verify(repositoryClient).save(modify);
    }

    @Test
    void Given_a_clientByID_when_delete_then_return_true(){
        Client client = new Client(123L, "Cll 6", "Juan", new Date("15/10/23"));
        boolean resultado = clientService.deleteClient(client.getId());

        Assertions.assertTrue(resultado);
    }

    @Test
    void Given_a_client_with_IDNull_when_delete_then_return_RunTimeException(){
        Client client = new Client(null, "Cra 9", "Paola", new Date("12/8/23"));
        Assertions.assertThrows(RuntimeException.class, () -> {
            clientService.deleteClient(client.getId());
        });
    }


}
