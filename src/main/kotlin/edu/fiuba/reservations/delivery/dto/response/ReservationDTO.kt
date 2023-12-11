package edu.fiuba.reservations.delivery.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.utils.Constants.ARGENTINE_TIME_ZONE
import edu.fiuba.reservations.utils.Constants.DATETIME_RFC3339_PATTERN
import java.math.BigDecimal
import java.time.ZonedDateTime

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class ReservationDTO(
    val id: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATETIME_RFC3339_PATTERN, timezone = ARGENTINE_TIME_ZONE)
    val flightDate: ZonedDateTime?,
    val airline: AirlineCode?,
    val origin: AirportCode?,
    val destination: AirportCode?,
    val passengersQuantity: Int?,
    val totalPrice: BigDecimal?,
    val customer: CustomerDTO?
) {
    constructor(id: String) : this(
        id = id,
        flightDate = null,
        airline = null,
        origin = null,
        destination = null,
        passengersQuantity = null,
        totalPrice = null,
        customer = null
    )

    constructor(entity: Reservation) : this(
        id = entity.id,
        flightDate = entity.flightDate,
        airline = entity.airline,
        origin = entity.origin,
        destination = entity.destination,
        passengersQuantity = entity.passengersQuantity,
        totalPrice = entity.totalPrice,
        customer = CustomerDTO(entity.customer)
    )
}
