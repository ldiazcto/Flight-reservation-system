package edu.fiuba.reservations.infrastructure.client.persistence.mapper

import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.domain.enums.fromCode
import edu.fiuba.reservations.infrastructure.client.persistence.entity.ReservationEntity
import edu.fiuba.reservations.utils.Constants.DATETIME_PATTERN
import edu.fiuba.reservations.utils.formatToString
import edu.fiuba.reservations.utils.toDateFromPatternWithHours

object ReservationEntityMapper {
    fun toReservationDomain(entity: ReservationEntity): Reservation {
        return Reservation(
            id = entity.id.uppercase(),
            flightDate = entity.flightDate.toDateFromPatternWithHours(DATETIME_PATTERN)!!,
            airline = AirlineCode.fromCode(entity.airline)!!,
            origin = AirportCode.fromCode(entity.origin)!!,
            destination = AirportCode.fromCode(entity.destination)!!,
            passengersQuantity = entity.passengersQuantity,
            totalPrice = entity.totalPrice,
            customer = CustomerEntityMapper.toCustomerDomain(entity.customer)
        )
    }

    fun toReservationEntity(domain: Reservation): ReservationEntity {
        return ReservationEntity(
            id = domain.id.uppercase(),
            flightDate = domain.flightDate.formatToString(DATETIME_PATTERN),
            airline = domain.airline.type,
            origin = domain.origin.type,
            destination = domain.destination.type,
            passengersQuantity = domain.passengersQuantity,
            totalPrice = domain.totalPrice,
            customer = CustomerEntityMapper.toCustomerEntity(domain.customer)
        )
    }
}
