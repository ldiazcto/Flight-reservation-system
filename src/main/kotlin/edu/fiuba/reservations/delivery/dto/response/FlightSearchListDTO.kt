package edu.fiuba.reservations.delivery.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import edu.fiuba.reservations.domain.entity.FlightSearch
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.utils.Constants
import java.math.BigDecimal
import java.time.ZonedDateTime

data class FlightSearchListDTO(
    val flights: List<FlightSearchDTO>
) {
    data class FlightSearchDTO(
        val id: String,
        val airline: AirlineCode,
        val originAirport: AirportCode,
        val destinationAirport: AirportCode,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATETIME_RFC3339_PATTERN, timezone = Constants.ARGENTINE_TIME_ZONE)
        val plannedDepartureTime: ZonedDateTime,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATETIME_RFC3339_PATTERN, timezone = Constants.ARGENTINE_TIME_ZONE)
        val plannedArrivalTime: ZonedDateTime,
        val price: BigDecimal
    ) {
        constructor(entity: FlightSearch) : this(
            id = entity.id,
            airline = entity.airline,
            originAirport = entity.originAirport,
            destinationAirport = entity.destinationAirport,
            plannedDepartureTime = entity.plannedDepartureTime,
            plannedArrivalTime = entity.plannedArrivalTime,
            price = entity.price
        )
    }
}
