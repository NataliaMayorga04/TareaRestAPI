package com.api.vet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "PET", uniqueConstraints = @UniqueConstraint(columnNames = {"CLIENT"}))
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pet {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DATE_CREATED")
    private Date dateCreated;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT")
    private Client client;

    public Pet(Client client, Long id, String name, Date dateCreated) {
        this.client = client;
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }
}
