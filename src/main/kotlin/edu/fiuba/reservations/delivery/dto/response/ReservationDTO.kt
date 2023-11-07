package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.enums.AirlineCode
import java.time.ZonedDateTime

data class ReservationDTO(
    val id: String,
    val flightDate: ZonedDateTime,
    val airline: AirlineCode
)
