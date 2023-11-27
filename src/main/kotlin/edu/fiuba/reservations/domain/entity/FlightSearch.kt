package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import java.math.BigDecimal
import java.time.ZonedDateTime

data class FlightSearch(
    val id: String,
    val airline: AirlineCode,
    val originAirport: AirportCode,
    val destinationAirport: AirportCode,
    val departureTime: ZonedDateTime,
    val arrivalTime: ZonedDateTime,
    val price: BigDecimal
)
