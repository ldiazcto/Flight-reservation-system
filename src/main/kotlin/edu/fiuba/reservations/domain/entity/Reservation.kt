package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.delivery.dto.request.CreateReservationDTO
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.utils.Constants.RESERVATION_ID_LENGTH
import org.apache.commons.lang3.RandomStringUtils
import java.math.BigDecimal
import java.time.ZonedDateTime

data class Reservation(
    val id: String,
    val flightDate: ZonedDateTime,
    val airline: AirlineCode,
    val origin: AirportCode,
    val destination: AirportCode,
    val passengersQuantity: Int,
    val totalPrice: BigDecimal,
    val customer: Customer
) {
    constructor(entity: CreateReservationDTO) : this(
        id = RandomStringUtils.random(RESERVATION_ID_LENGTH, true, false),
        flightDate = entity.flightDate!!,
        airline = entity.airline!!,
        origin = entity.origin!!,
        destination = entity.destination!!,
        passengersQuantity = entity.passengersQuantity!!,
        totalPrice = entity.totalPrice!!,
        customer = Customer(entity.customer!!)
    )
}
