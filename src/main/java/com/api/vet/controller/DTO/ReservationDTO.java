package com.api.vet.controller.DTO;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@Data
public class ReservationDTO {
    private Long idReserva;
    private Date reservationDate;

}
