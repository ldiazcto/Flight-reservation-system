package edu.fiuba.reservations.delivery.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import edu.fiuba.reservations.domain.entity.Flight
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.domain.enums.CountryCode
import edu.fiuba.reservations.domain.enums.FlightType
import edu.fiuba.reservations.domain.enums.StateCode
import edu.fiuba.reservations.utils.Constants.ARGENTINE_TIME_ZONE
import edu.fiuba.reservations.utils.Constants.DATETIME_RFC3339_PATTERN
import java.math.BigDecimal
import java.time.ZonedDateTime

data class FlightDTO(
    val id: String,
    val airline: AirlineCode,
    val type: FlightType,
    val originAirport: AirportCode,
    val originCity: String,
    val originState: StateCode,
    val originCountry: CountryCode,
    val destinationAirport: AirportCode,
    val destinationCity: String,
    val destinationState: StateCode,
    val destinationCountry: CountryCode,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATETIME_RFC3339_PATTERN, timezone = ARGENTINE_TIME_ZONE)
    val plannedDepartureTime: ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATETIME_RFC3339_PATTERN, timezone = ARGENTINE_TIME_ZONE)
    val realDepartureTime: ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATETIME_RFC3339_PATTERN, timezone = ARGENTINE_TIME_ZONE)
    val plannedArrivalTime: ZonedDateTime,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATETIME_RFC3339_PATTERN, timezone = ARGENTINE_TIME_ZONE)
    val realArrivalTime: ZonedDateTime,
    val price: BigDecimal
) {
    constructor(entity: Flight) : this(
        id = entity.id,
        type = entity.type,
        airline = entity.airline,
        originAirport = entity.originAirport,
        originCity = entity.originCity,
        originState = entity.originState,
        originCountry = entity.originCountry,
        destinationAirport = entity.destinationAirport,
        destinationCity = entity.destinationCity,
        destinationState = entity.destinationState,
        destinationCountry = entity.destinationCountry,
        plannedDepartureTime = entity.plannedDepartureTime,
        realDepartureTime = entity.realDepartureTime,
        plannedArrivalTime = entity.plannedArrivalTime,
        realArrivalTime = entity.realArrivalTime,
        price = entity.price
    )
}
