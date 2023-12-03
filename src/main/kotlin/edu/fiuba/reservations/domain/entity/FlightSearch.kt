package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.domain.enums.fromPartialValue
import edu.fiuba.reservations.domain.enums.fromValue
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
        id = entity.get("flight_id"),
        airline = AirlineCode.fromValue(entity.get("airline").replace(" ", "_"))!!,
        originAirport = AirportCode.fromPartialValue(entity.get("origin_airport"))!!,
        destinationAirport = AirportCode.fromPartialValue(entity.get("destination_airport"))!!,
        plannedDepartureTime = ZonedDateTime.parse(entity.get("planned_departure")),
        plannedArrivalTime = ZonedDateTime.parse(entity.get("planned_arrival")),
        price = entity.get("price").toCustomBigDecimal()
    )
}
