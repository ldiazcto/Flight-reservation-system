package edu.fiuba.reservations.delivery.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.utils.Constants.ARGENTINE_TIME_ZONE
import edu.fiuba.reservations.utils.Constants.DATETIME_RFC3339_PATTERN
import java.time.ZonedDateTime

data class ReservationDTO(
    val id: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATETIME_RFC3339_PATTERN, timezone = ARGENTINE_TIME_ZONE)
    val flightDate: ZonedDateTime,
    val airline: AirlineCode
) {
    constructor(entity: Reservation) : this(
        entity.id,
        entity.flightDate,
        entity.airline
    )
}
