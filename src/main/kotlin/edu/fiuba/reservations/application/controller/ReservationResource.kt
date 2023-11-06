package edu.fiuba.reservations.application.controller

import edu.fiuba.reservations.delivery.controller.ReservationController
import edu.fiuba.reservations.delivery.dto.response.ReservationDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus

class ReservationResource(
    private val reservationController: ReservationController
) {
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getReservations(
        @PathVariable id: String
    ): ResponseEntity<ReservationDTO> {
        return reservationController.getReservation(id).toDTO()
    }
}
