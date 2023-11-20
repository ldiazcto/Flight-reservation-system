package edu.fiuba.reservations.application.controller

import edu.fiuba.reservations.delivery.controller.ReservationController
import edu.fiuba.reservations.delivery.dto.response.ReservationDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("reservations")
class ReservationResource(
    private val reservationController: ReservationController
) {
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getReservation(
        @PathVariable id: String
    ): ReservationDTO {
        return reservationController.getReservation(id)
    }
}
