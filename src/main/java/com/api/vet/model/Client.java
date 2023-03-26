package com.api.vet.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "CLIENT")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Id
    @Column(name = "DOCUMENT")
    private Long id;
    @Column(length = 50, nullable = false, name = "ADDRESS")
    private String address;
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DATE_CREATED")
    private Date dateCreated;

    @JsonManagedReference
    @OneToMany(mappedBy = "client",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>();

}

