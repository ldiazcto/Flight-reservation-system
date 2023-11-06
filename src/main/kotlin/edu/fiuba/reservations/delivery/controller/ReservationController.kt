package edu.fiuba.reservations.delivery.controller

import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.infrastructure.service.ReservationService

class ReservationController(
    private val reservationService: ReservationService
) {
    fun getReservation(id: String): Reservation {
        return reservationService.getReservation(id)
    }
}
