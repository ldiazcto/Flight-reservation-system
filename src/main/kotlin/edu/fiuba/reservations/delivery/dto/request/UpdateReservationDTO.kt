package edu.fiuba.reservations.delivery.dto.request

import edu.fiuba.reservations.delivery.dto.response.CustomerDTO

data class UpdateReservationDTO(
    val flightDate: String?,
    val passengersQuantity: String?,
    val totalPrice: String?,
    val customer: CustomerDTO?
) {
    constructor(entity: UpdateReservationDTO) : this(
        flightDate = entity.flightDate,
        passengersQuantity = entity.passengersQuantity,
        totalPrice = entity.totalPrice,
        customer = entity.customer?.let { CustomerDTO(it) }
    )
}
