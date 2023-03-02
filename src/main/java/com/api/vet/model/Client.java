package com.api.vet.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Client {
    private String address;
    private String name;
    private String petName;

    @Id
    private Long id;
}



