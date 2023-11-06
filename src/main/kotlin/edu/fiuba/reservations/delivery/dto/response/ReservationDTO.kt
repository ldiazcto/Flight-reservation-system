package edu.fiuba.reservations.delivery.dto.response

import java.time.ZonedDateTime

data class ReservationDTO(
    val id: String,
    val flightDate: ZonedDateTime,
    val airline: AirlineCode
)
