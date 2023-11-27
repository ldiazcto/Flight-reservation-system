package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.delivery.dto.request.FlightCriteriaDTO
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.domain.enums.fromValue
import edu.fiuba.reservations.utils.Constants.DATE_PATTERN
import edu.fiuba.reservations.utils.toDateFromPatternWithoutHours
import java.time.ZonedDateTime

data class FlightCriteria(
    val airline: AirlineCode,
    val origin: AirportCode,
    val destination: AirportCode,
    val from: ZonedDateTime,
    val to: ZonedDateTime
) {
    constructor(entity: FlightCriteriaDTO) : this(
        airline = entity.airline?.let { AirlineCode.fromValue(it) }!!,
        origin = entity.origin?.let { AirportCode.fromValue(it) }!!,
        destination = entity.destination?.let { AirportCode.fromValue(it) }!!,
        from = entity.from?.toDateFromPatternWithoutHours(DATE_PATTERN)!!,
        to = entity.to?.toDateFromPatternWithoutHours(DATE_PATTERN)?.plusDays(1)?.minusNanos(1)!!
    )
}
