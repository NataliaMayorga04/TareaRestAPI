package com.api.vet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Id

    private Long id;
    @Column(length = 50, nullable = false)
    private String address;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String petName;

}

