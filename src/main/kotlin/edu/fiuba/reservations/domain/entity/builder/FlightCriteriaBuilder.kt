package edu.fiuba.reservations.domain.entity.builder

import edu.fiuba.reservations.application.exception.ExceptionCode
import edu.fiuba.reservations.delivery.dto.request.FlightCriteriaDTO
import edu.fiuba.reservations.domain.entity.Error
import edu.fiuba.reservations.domain.entity.FlightCriteria
import edu.fiuba.reservations.domain.exception.BadRequestException
import edu.fiuba.reservations.domain.validator.FlightCriteriaValidator

class FlightCriteriaBuilder(
    val validator: FlightCriteriaValidator
) {
    fun build(data: FlightCriteriaDTO): FlightCriteria {
        val exceptions = validator.validate(data, ArrayList())

        if (exceptions.isEmpty()) {
            return FlightCriteria(data)
        } else {
            throw BadRequestException(
                ExceptionCode.INVALID_FLIGHT_CRITERIA.getMessage(),
                ExceptionCode.INVALID_FLIGHT_CRITERIA.getCode(),
                exceptions.map { Error(it) }
            )
        }
    }
}
