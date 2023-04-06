package com.api.vet.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKING", uniqueConstraints = @UniqueConstraint(columnNames = {"CLIENT_ID", "DATE"}))
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idReserva;

    @Column(nullable = false, name = "DATE")
    private Date reservationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    public Reservation(Client client, Long idReserva, Date reservationDate, Pet pet) {
        this.client = client;
        this.idReserva = idReserva;
        this.reservationDate = reservationDate;
        this.pet = pet;
    }
}
