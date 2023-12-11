package edu.fiuba.reservations.delivery.dto.request

import edu.fiuba.reservations.delivery.dto.response.CustomerDTO

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
}
