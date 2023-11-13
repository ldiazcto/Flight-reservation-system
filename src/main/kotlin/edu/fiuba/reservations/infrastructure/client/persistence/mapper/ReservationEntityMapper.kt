package edu.fiuba.reservations.infrastructure.client.persistence.mapper

import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.fromCode
import edu.fiuba.reservations.infrastructure.client.persistence.entity.ReservationEntity
import edu.fiuba.reservations.utils.Constants.DATETIME_PATTERN
import edu.fiuba.reservations.utils.toDateFromPatternWithHours

object ReservationEntityMapper {
    fun toReservationDomain(entity: ReservationEntity): Reservation {
        return Reservation(
            id = entity.id,
            flightDate = entity.flightDate.toDateFromPatternWithHours(DATETIME_PATTERN)!!,
            airline = AirlineCode.fromCode(entity.airline)!!
        )
    }
}
