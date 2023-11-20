package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.domain.enums.AirlineCode
import java.time.ZonedDateTime

data class FlightSearch(
    val id: String,
    val airline: AirlineCode,
    val departureTime: ZonedDateTime,
    val arrivalTime: ZonedDateTime,
    val originAirport: String,
    val destinationAirport: String
)
