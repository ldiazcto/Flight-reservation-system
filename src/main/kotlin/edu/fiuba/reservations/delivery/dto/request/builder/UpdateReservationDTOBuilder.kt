package edu.fiuba.reservations.delivery.dto.request.builder

import edu.fiuba.reservations.application.exception.ExceptionCode.INVALID_RESERVATION_BODY
import edu.fiuba.reservations.delivery.dto.request.UpdateReservationDTO
import edu.fiuba.reservations.delivery.validator.UpdateReservationDTOValidator
import edu.fiuba.reservations.domain.entity.Error
import edu.fiuba.reservations.domain.exception.BadRequestException

class UpdateReservationDTOBuilder(
    private val validator: UpdateReservationDTOValidator
) {
    fun build(data: UpdateReservationDTO): UpdateReservationDTO {
        val exceptions = validator.validate(data, ArrayList())

        if (exceptions.isEmpty()) {
            return UpdateReservationDTO(data)
        } else {
            throw BadRequestException(
                INVALID_RESERVATION_BODY.getMessage(),
                INVALID_RESERVATION_BODY.getCode(),
                exceptions.map { Error(it) }
            )
        }
    }
}
