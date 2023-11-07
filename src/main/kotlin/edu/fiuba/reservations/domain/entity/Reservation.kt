package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.delivery.dto.response.ReservationDTO
import edu.fiuba.reservations.domain.enums.AirlineCode
import java.time.ZonedDateTime

data class Reservation(
    val id: String,
    val flightDate: ZonedDateTime,
    val airline: AirlineCode
) {
    fun toDTO(): ReservationDTO {
        return ReservationDTO(
            id = id,
            flightDate = flightDate,
            airline = airline
        )
    }
}
