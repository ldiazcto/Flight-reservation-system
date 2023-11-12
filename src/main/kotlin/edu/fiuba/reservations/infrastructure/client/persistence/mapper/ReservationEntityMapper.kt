package edu.fiuba.reservations.infrastructure.client.persistence.mapper

import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.fromCode
import edu.fiuba.reservations.infrastructure.client.persistence.entity.ReservationEntity
import edu.fiuba.reservations.utils.YYYY_MM_DD_HH_MM_SS_SSSS
import edu.fiuba.reservations.utils.toDateFromPatternWithHours

object ReservationEntityMapper {
    fun toReservationDomain(entity: ReservationEntity): Reservation {
        return Reservation(
            id = entity.id,
            flightDate = entity.flightDate.toDateFromPatternWithHours(YYYY_MM_DD_HH_MM_SS_SSSS)!!,
            airline = AirlineCode.fromCode(entity.airline)!!
        )
    }
}
