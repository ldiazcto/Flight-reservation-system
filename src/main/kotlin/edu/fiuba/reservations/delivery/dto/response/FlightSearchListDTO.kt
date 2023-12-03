package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.entity.FlightSearch
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
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
        val plannedDepartureTime: ZonedDateTime,
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
