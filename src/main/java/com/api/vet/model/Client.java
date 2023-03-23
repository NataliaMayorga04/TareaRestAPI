package com.api.vet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="CLIENT")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Id
    @Column(name="DOCUMENT")
    private Long id;
    @Column(length = 50, nullable = false, name="ADDRESS")
    private String address;
    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="DATE_CREATED")
    private Date dateCreated;

}

