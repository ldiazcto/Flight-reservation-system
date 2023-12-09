package edu.fiuba.reservations.infrastructure.client.persistence.entity

import java.math.BigDecimal
import java.math.BigInteger.ZERO

data class ReservationEntity(
    var id: String = String(),
    val flightDate: String = String(),
    val airline: String = String(),
    val origin: String = String(),
    val destination: String = String(),
    val passengersQuantity: Int = ZERO.toInt(),
    val totalPrice: BigDecimal = BigDecimal.ZERO,
    val customer: CustomerEntity = CustomerEntity()
)
