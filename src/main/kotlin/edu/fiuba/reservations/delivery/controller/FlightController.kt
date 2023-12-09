package edu.fiuba.reservations.delivery.controller

import edu.fiuba.reservations.application.exception.ExceptionCode.INVALID_FLIGHT_ID
import edu.fiuba.reservations.delivery.dto.request.FlightCriteriaDTO
import edu.fiuba.reservations.delivery.dto.request.builder.FlightCriteriaDTOBuilder
import edu.fiuba.reservations.delivery.dto.response.FlightDTO
import edu.fiuba.reservations.delivery.dto.response.FlightSearchListDTO
import edu.fiuba.reservations.delivery.dto.response.FlightSearchListDTO.FlightSearchDTO
import edu.fiuba.reservations.delivery.validator.FlightCriteriaDTOValidator
import edu.fiuba.reservations.domain.exception.BadRequestException
import edu.fiuba.reservations.infrastructure.service.FlightService
import edu.fiuba.reservations.utils.Constants.FLIGHT_ID_LENGTH

class FlightController(
    private val flightService: FlightService
) {
    fun getFlights(flightCriteria: FlightCriteriaDTO): FlightSearchListDTO {
        val validatedFlightCriteria = FlightCriteriaDTOBuilder(FlightCriteriaDTOValidator()).build(flightCriteria)

        return FlightSearchListDTO(
            flightService.getFlights(validatedFlightCriteria).map {
                FlightSearchDTO(it)
            }
        )
    }

    fun getFlight(id: String): FlightDTO {
        validateFlightId(id)

        return FlightDTO(flightService.getFlight(id))
    }

    private fun validateFlightId(id: String) {
        if (id.length != FLIGHT_ID_LENGTH) {
            throw BadRequestException(
                INVALID_FLIGHT_ID.getMessage(),
                INVALID_FLIGHT_ID.getCode(),
                listOf()
            )
        }
    }
}
