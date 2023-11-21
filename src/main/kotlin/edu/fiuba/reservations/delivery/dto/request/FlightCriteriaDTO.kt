package edu.fiuba.reservations.delivery.dto.request

import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.utils.getCurrentDate

data class FlightCriteriaDTO(
    val airline: String? = AirlineCode.ALL.name,
    val from: String? = getCurrentDate(),
    val to: String?
) {
    constructor(entity: FlightCriteriaDTO) : this(
        entity.airline,
        entity.from,
        entity.to
    )
}
