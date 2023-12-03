package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.domain.enums.CountryCode
import edu.fiuba.reservations.domain.enums.FlightType
import edu.fiuba.reservations.domain.enums.StateCode
import edu.fiuba.reservations.domain.enums.fromPartialValue
import edu.fiuba.reservations.domain.enums.fromValue
import edu.fiuba.reservations.utils.toCustomBigDecimal
import org.apache.commons.csv.CSVRecord
import java.math.BigDecimal
import java.time.ZonedDateTime

data class Flight(
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
    val plannedDepartureTime: ZonedDateTime,
    val realDepartureTime: ZonedDateTime,
    val plannedArrivalTime: ZonedDateTime,
    val realArrivalTime: ZonedDateTime,
    val price: BigDecimal
) {
    constructor(entity: CSVRecord) : this(
        id = entity.get("flight_id"),
        airline = AirlineCode.fromValue(entity.get("airline").replace(" ", "_"))!!,
        type = FlightType.fromValue(entity.get("flight_type"))!!,
        originAirport = AirportCode.fromPartialValue(entity.get("origin_airport"))!!,
        originCity = entity.get("origin_city"),
        originState = StateCode.fromValue(
            "${entity.get("origin_country").substring(0, 2)}_${entity.get("origin_state")}"
        )!!,
        originCountry = CountryCode.fromValue(entity.get("origin_country").substring(0, 3))!!,
        destinationAirport = AirportCode.fromPartialValue(entity.get("destination_airport"))!!,
        destinationCity = entity.get("destination_city"),
        destinationState = StateCode.fromValue(
            "${entity.get("destination_country").substring(0, 2)}_${entity.get("destination_state")}"
        )!!,
        destinationCountry = CountryCode.fromValue(entity.get("destination_country").substring(0, 3))!!,
        plannedDepartureTime = ZonedDateTime.parse(entity.get("planned_departure")),
        realDepartureTime = ZonedDateTime.parse(entity.get("real_departure")),
        plannedArrivalTime = ZonedDateTime.parse(entity.get("planned_arrival")),
        realArrivalTime = ZonedDateTime.parse(entity.get("real_arrival")),
        price = entity.get("price").toCustomBigDecimal()
    )
}
