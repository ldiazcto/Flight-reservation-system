package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.delivery.dto.request.CreateReservationDTO
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.domain.enums.fromValue
import edu.fiuba.reservations.utils.Constants.DATETIME_RFC3339_PATTERN
import edu.fiuba.reservations.utils.Constants.RESERVATION_ID_LENGTH
import edu.fiuba.reservations.utils.toDateFromPatternWithHours
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
        flightDate = entity.flightDate!!.toDateFromPatternWithHours(DATETIME_RFC3339_PATTERN)!!,
        airline = AirlineCode.fromValue(entity.airline!!)!!,
        origin = AirportCode.fromValue(entity.origin!!)!!,
        destination = AirportCode.fromValue(entity.destination!!)!!,
        passengersQuantity = entity.passengersQuantity!!.toInt(),
        totalPrice = entity.totalPrice!!.toBigDecimal(),
        customer = Customer(entity.customer!!)
    )
}
