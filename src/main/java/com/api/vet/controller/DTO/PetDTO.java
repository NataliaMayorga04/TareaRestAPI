package com.api.vet.controller.DTO;

import com.api.vet.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter

public class PetDTO {
    private Long id;
    private String name;
    private Date dateCreated;
    private Client client;

}
