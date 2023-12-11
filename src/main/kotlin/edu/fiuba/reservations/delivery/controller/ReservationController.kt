package edu.fiuba.reservations.delivery.controller

import edu.fiuba.reservations.delivery.dto.request.CreateReservationDTO
import edu.fiuba.reservations.delivery.dto.response.ReservationDTO
import edu.fiuba.reservations.infrastructure.service.ReservationService

class ReservationController(
    private val reservationService: ReservationService
) {
    fun getReservation(id: String): ReservationDTO {
        return ReservationDTO(reservationService.getReservation(id))
    }

    fun createReservation(body: CreateReservationDTO): ReservationDTO {
        return ReservationDTO(reservationService.createReservation(body))
    }
}
