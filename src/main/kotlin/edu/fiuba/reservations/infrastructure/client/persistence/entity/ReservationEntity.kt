package edu.fiuba.reservations.infrastructure.client.persistence.entity

data class ReservationEntity(
    var id: String = String(),
    val flightDate: String = String(),
    val airline: String = String(),
)
