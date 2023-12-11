package edu.fiuba.reservations.delivery.dto.request

import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.utils.getCurrentDate

data class FlightCriteriaDTO(
    val airline: String? = AirlineCode.ALL.name,
    val origin: String?,
    val destination: String?,
    val from: String? = getCurrentDate(),
    val to: String?
) {
    constructor(entity: FlightCriteriaDTO) : this(
        airline = entity.airline,
        origin = entity.origin,
        destination = entity.destination,
        from = entity.from,
        to = entity.to
    )
}
