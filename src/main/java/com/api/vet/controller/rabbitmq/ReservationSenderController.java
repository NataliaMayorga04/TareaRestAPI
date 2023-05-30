package com.api.vet.controller.rabbitmq;

import com.api.vet.controller.DTO.ReservationDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/client")
public class ReservationSenderController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ReservationSenderController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping(value = "/reservations")
    public ResponseEntity<String> sendReservation(@RequestBody ReservationDTO reservationDTO) {
        try {
            // Convert ReservationDTO to JSON
            String reservationJson = convertReservationDTOToJson(reservationDTO);

            // Send ReservationDTO as message to RabbitMQ queue
            rabbitTemplate.convertAndSend("adminReservasb","email", reservationJson);

            return new ResponseEntity<>("Reservation sent to RabbitMQ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String convertReservationDTOToJson(ReservationDTO reservationDTO) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(reservationDTO);
    }
}