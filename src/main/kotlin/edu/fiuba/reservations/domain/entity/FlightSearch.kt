package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.domain.enums.fromPartialValue
import edu.fiuba.reservations.domain.enums.fromValue
import edu.fiuba.reservations.infrastructure.client.file.header.FlightHeader
import edu.fiuba.reservations.utils.toCustomBigDecimal
import org.apache.commons.csv.CSVRecord
import java.math.BigDecimal
import java.time.ZonedDateTime

data class FlightSearch(
    val id: String,
    val airline: AirlineCode,
    val originAirport: AirportCode,
    val destinationAirport: AirportCode,
    val plannedDepartureTime: ZonedDateTime,
    val plannedArrivalTime: ZonedDateTime,
    val price: BigDecimal
) {
    constructor(entity: CSVRecord) : this(
        id = entity.get(FlightHeader.FLIGHT_ID.label),
        airline = AirlineCode.fromValue(entity.get(FlightHeader.AIRLINE.label).replace(" ", "_"))!!,
        originAirport = AirportCode.fromPartialValue(entity.get(FlightHeader.ORIGIN_AIRPORT.label))!!,
        destinationAirport = AirportCode.fromPartialValue(entity.get(FlightHeader.DESTINATION_AIRPORT.label))!!,
        plannedDepartureTime = ZonedDateTime.parse(entity.get(FlightHeader.PLANNED_DEPARTURE.label)),
        plannedArrivalTime = ZonedDateTime.parse(entity.get(FlightHeader.PLANNED_ARRIVAL.label)),
        price = entity.get(FlightHeader.PRICE.label).toCustomBigDecimal()
    )
}
