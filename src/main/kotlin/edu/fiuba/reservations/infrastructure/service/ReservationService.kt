package edu.fiuba.reservations.infrastructure.service

import edu.fiuba.reservations.delivery.dto.request.CreateReservationDTO
import edu.fiuba.reservations.delivery.dto.request.UpdateReservationDTO
import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.domain.entity.builder.ReservationBuilder
import edu.fiuba.reservations.domain.validator.ReservationValidator
import edu.fiuba.reservations.infrastructure.client.persistence.ReservationPersistence
import org.springframework.stereotype.Service

@Service
class ReservationService(
    private val reservationPersistence: ReservationPersistence
) {
    fun getReservation(id: String): Pair<String, Reservation> {
        return reservationPersistence.getReservation(id)
    }

    fun createReservation(body: CreateReservationDTO): String {
        val reservation = ReservationBuilder(ReservationValidator()).build(body)

        return reservationPersistence.createReservation(reservation).id
    }

    fun updateReservation(id: String, body: UpdateReservationDTO): String {
        val (documentId, originalReservation) = getReservation(id)
        val partialMergeReservation = CreateReservationDTO(originalReservation, body)

        val partialUpdatedReservation = ReservationBuilder(ReservationValidator()).build(partialMergeReservation)
        val updatedReservation = Reservation(originalReservation, partialUpdatedReservation)

        return reservationPersistence.updateReservation(documentId, updatedReservation).id
    }

    fun deleteReservation(id: String) {
        reservationPersistence.deleteReservation(id)
    }
}
