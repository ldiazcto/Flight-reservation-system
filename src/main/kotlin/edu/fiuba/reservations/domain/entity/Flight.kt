package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.domain.enums.CountryCode
import edu.fiuba.reservations.domain.enums.FlightType
import edu.fiuba.reservations.domain.enums.StateCode
import edu.fiuba.reservations.domain.enums.fromPartialValue
import edu.fiuba.reservations.domain.enums.fromValue
import edu.fiuba.reservations.infrastructure.client.file.header.FlightHeader
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
        id = entity.get(FlightHeader.FLIGHT_ID.label),
        airline = AirlineCode.fromValue(entity.get(FlightHeader.AIRLINE.label).replace(" ", "_"))!!,
        type = FlightType.fromValue(entity.get(FlightHeader.FLIGHT_TYPE.label))!!,
        originAirport = AirportCode.fromPartialValue(entity.get(FlightHeader.ORIGIN_AIRPORT.label).replace(" ", "_"))!!,
        originCity = entity.get(FlightHeader.ORIGIN_CITY.label),
        originState = StateCode.fromValue(
            "${entity.get(FlightHeader.ORIGIN_COUNTRY.label).substring(0, 2)}_${entity.get(FlightHeader.ORIGIN_STATE.label)}"
        )!!,
        originCountry = CountryCode.fromValue(entity.get(FlightHeader.ORIGIN_COUNTRY.label).substring(0, 3))!!,
        destinationAirport = AirportCode.fromPartialValue(entity.get(FlightHeader.DESTINATION_AIRPORT.label).replace(" ", "_"))!!,
        destinationCity = entity.get(FlightHeader.DESTINATION_CITY.label),
        destinationState = StateCode.fromValue(
            "${entity.get(FlightHeader.DESTINATION_COUNTRY.label).substring(0, 2)}_${entity.get(FlightHeader.DESTINATION_STATE.label)}"
        )!!,
        destinationCountry = CountryCode.fromValue(entity.get(FlightHeader.DESTINATION_COUNTRY.label).substring(0, 3))!!,
        plannedDepartureTime = ZonedDateTime.parse(entity.get(FlightHeader.PLANNED_DEPARTURE.label)),
        realDepartureTime = ZonedDateTime.parse(entity.get(FlightHeader.REAL_DEPARTURE.label)),
        plannedArrivalTime = ZonedDateTime.parse(entity.get(FlightHeader.PLANNED_ARRIVAL.label)),
        realArrivalTime = ZonedDateTime.parse(entity.get(FlightHeader.REAL_ARRIVAL.label)),
        price = entity.get(FlightHeader.PRICE.label).toCustomBigDecimal()
    )
}
