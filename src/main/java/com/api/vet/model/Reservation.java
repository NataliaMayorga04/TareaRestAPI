package com.api.vet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @Column(nullable = false)
    private String petName;

    @Column(nullable = false)
    private Date reservationDate;

    @Column
    private String note;

    @Column
    private Long clientID;
}
