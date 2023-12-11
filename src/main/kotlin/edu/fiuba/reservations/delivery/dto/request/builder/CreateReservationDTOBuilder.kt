package edu.fiuba.reservations.delivery.dto.request.builder

import edu.fiuba.reservations.application.exception.ExceptionCode.INVALID_RESERVATION_BODY
import edu.fiuba.reservations.delivery.dto.request.CreateReservationDTO
import edu.fiuba.reservations.delivery.validator.CreateReservationDTOValidator
import edu.fiuba.reservations.domain.entity.Error
import edu.fiuba.reservations.domain.exception.BadRequestException

class CreateReservationDTOBuilder(
    private val validator: CreateReservationDTOValidator
) {
    fun build(data: CreateReservationDTO): CreateReservationDTO {
        val exceptions = validator.validate(data, ArrayList())

        if (exceptions.isEmpty()) {
            return CreateReservationDTO(data)
        } else {
            throw BadRequestException(
                INVALID_RESERVATION_BODY.getMessage(),
                INVALID_RESERVATION_BODY.getCode(),
                exceptions.map { Error(it) }
            )
        }
    }
}
