package edu.fiuba.reservations.infrastructure.service

import edu.fiuba.reservations.domain.entity.Reservation

class ReservationService(
    private val reservationPersistence: ReservationPersistenceImpl
) {
    fun getReservation(id: String): Reservation {
        return reservationPersistence.getReservation(id)
    }
}

