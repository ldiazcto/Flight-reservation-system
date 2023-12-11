package edu.fiuba.reservations.delivery.dto.request.builder

import edu.fiuba.reservations.application.exception.ExceptionCode.INVALID_FLIGHT_CRITERIA
import edu.fiuba.reservations.delivery.dto.request.FlightCriteriaDTO
import edu.fiuba.reservations.delivery.validator.FlightCriteriaDTOValidator
import edu.fiuba.reservations.domain.entity.Error
import edu.fiuba.reservations.domain.exception.BadRequestException

class FlightCriteriaDTOBuilder(
    private val validator: FlightCriteriaDTOValidator
) {
    fun build(data: FlightCriteriaDTO): FlightCriteriaDTO {
        val exceptions = validator.validate(data, ArrayList())

        if (exceptions.isEmpty()) {
            return FlightCriteriaDTO(data)
        } else {
            throw BadRequestException(
                INVALID_FLIGHT_CRITERIA.getMessage(),
                INVALID_FLIGHT_CRITERIA.getCode(),
                exceptions.map { Error(it) }
            )
        }
    }
}
