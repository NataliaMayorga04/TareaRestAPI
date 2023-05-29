package com.api.vet.controller.DTO;

import com.api.vet.model.Client;
import com.api.vet.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class ReservationDTO {
    private Long idReserva;
    private Date reservationDate;
    private Client client;
    private Pet pet;

    public ReservationDTO() {

    }
}
