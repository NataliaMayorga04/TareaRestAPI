package com.api.vet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="PET")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pet {
    @Id
    @Column(name="ID")
    private Long id;
    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="DATE_CREATED")
    private Date dateCreated;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT")
    private Client client;



}
