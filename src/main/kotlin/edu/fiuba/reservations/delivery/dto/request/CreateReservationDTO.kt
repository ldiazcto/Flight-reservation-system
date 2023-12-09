package edu.fiuba.reservations.delivery.dto.request

import edu.fiuba.reservations.delivery.dto.response.CustomerDTO
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import java.math.BigDecimal
import java.time.ZonedDateTime

data class CreateReservationDTO(
    val flightDate: ZonedDateTime?,
    val airline: AirlineCode?,
    val origin: AirportCode?,
    val destination: AirportCode?,
    val passengersQuantity: Int?,
    val totalPrice: BigDecimal?,
    val customer: CustomerDTO?
)
