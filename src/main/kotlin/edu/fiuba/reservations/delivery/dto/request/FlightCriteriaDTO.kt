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
        entity.airline,
        entity.origin,
        entity.destination,
        entity.from,
        entity.to
    )
}
