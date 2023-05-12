package com.api.vet.controller.DTO;
import lombok.Data;
import java.util.Date;

@Data

public class ClientDTO {
    private Long id;
    private String address;
    private String name;
    private Date dateCreated;
}
