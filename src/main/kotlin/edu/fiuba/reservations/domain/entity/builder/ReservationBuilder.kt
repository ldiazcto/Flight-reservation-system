package edu.fiuba.reservations.domain.entity.builder

import edu.fiuba.reservations.application.exception.ExceptionCode.INVALID_RESERVATION_BODY
import edu.fiuba.reservations.delivery.dto.request.CreateReservationDTO
import edu.fiuba.reservations.domain.entity.Error
import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.domain.exception.BadRequestException
import edu.fiuba.reservations.domain.validator.ReservationValidator

class ReservationBuilder(
    val validator: ReservationValidator
) {
    fun build(data: CreateReservationDTO): Reservation {
        val exceptions = validator.validate(data, ArrayList())

        if (exceptions.isEmpty()) {
            return Reservation(data)
        } else {
            throw BadRequestException(
                INVALID_RESERVATION_BODY.getMessage(),
                INVALID_RESERVATION_BODY.getCode(),
                exceptions.map { Error(it) }
            )
        }
    }
}
