package edu.fiuba.reservations.delivery.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.utils.DATE_TIME_ZONE
import edu.fiuba.reservations.utils.RFC3339PATTERN
import java.time.ZonedDateTime

data class ReservationDTO(
    val id: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = RFC3339PATTERN, timezone = DATE_TIME_ZONE)
    val flightDate: ZonedDateTime,
    val airline: AirlineCode
)
