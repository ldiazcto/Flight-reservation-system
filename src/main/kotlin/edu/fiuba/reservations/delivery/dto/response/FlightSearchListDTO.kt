package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.entity.FlightSearch

class FlightSearchListDTO(
    val flights: List<FlightSearchDTO>
) {
    data class FlightSearchDTO(
        val id: String
    ) {
        constructor(entity: FlightSearch) : this(
            entity.id
        )
    }
}
