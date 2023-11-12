package edu.fiuba.reservations.infrastructure.service

import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.infrastructure.client.persistence.ReservationPersistence
import org.springframework.stereotype.Service

@Service
class ReservationService(
    private val reservationPersistence: ReservationPersistence
) {
    fun getReservation(id: String): Reservation {
        return reservationPersistence.getReservation(id)
    }
}
