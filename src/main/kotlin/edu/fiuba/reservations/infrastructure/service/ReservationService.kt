package edu.fiuba.reservations.infrastructure.service

import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.infrastructure.client.persistence.repository.ReservationRepository
import org.springframework.stereotype.Service

@Service
class ReservationService(
    private val reservationRepository: ReservationRepository
) {
    fun getReservation(id: String): Reservation {
        return reservationRepository.get(id)
    }
}
