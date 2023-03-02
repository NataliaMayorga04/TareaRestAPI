package com.api.vet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Column(length = 50, nullable = false)
    private Date date;
    @Column(length = 10, nullable = false)
    private Long reservationID;
    @Column(nullable = false)
    private Client client;






}
