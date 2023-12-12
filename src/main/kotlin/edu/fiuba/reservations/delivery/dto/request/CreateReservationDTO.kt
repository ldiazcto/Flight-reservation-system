package edu.fiuba.reservations.delivery.dto.request

import edu.fiuba.reservations.delivery.dto.response.CustomerDTO
import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.utils.Constants.DATETIME_RFC3339_PATTERN
import edu.fiuba.reservations.utils.formatToString
import edu.fiuba.reservations.utils.ifNotNull
import edu.fiuba.reservations.utils.ifNotNullAndBlank

data class CreateReservationDTO(
    val flightDate: String?,
    val airline: String?,
    val origin: String?,
    val destination: String?,
    val passengersQuantity: String?,
    val totalPrice: String?,
    val customer: CustomerDTO?
) {
    constructor(entity: CreateReservationDTO) : this(
        flightDate = entity.flightDate,
        airline = entity.airline,
        origin = entity.origin,
        destination = entity.destination,
        passengersQuantity = entity.passengersQuantity,
        totalPrice = entity.totalPrice,
        customer = entity.customer?.let { CustomerDTO(it) }
    )

    constructor(entity: Reservation, updatedEntity: UpdateReservationDTO) : this(
        flightDate = updatedEntity.flightDate.ifNotNullAndBlank { it } ?: entity.flightDate.formatToString(DATETIME_RFC3339_PATTERN),
        airline = entity.airline.name,
        origin = entity.origin.name,
        destination = entity.destination.name,
        passengersQuantity = updatedEntity.passengersQuantity.ifNotNullAndBlank { it } ?: entity.passengersQuantity.toString(),
        totalPrice = updatedEntity.totalPrice.ifNotNullAndBlank { it } ?: entity.totalPrice.toString(),
        customer = updatedEntity.ifNotNull { CustomerDTO(entity.customer, updatedEntity.customer!!) } ?: CustomerDTO(entity.customer)
    )
}
