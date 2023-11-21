package edu.fiuba.reservations.delivery.controller

import edu.fiuba.reservations.delivery.dto.request.FlightCriteriaDTO
import edu.fiuba.reservations.delivery.dto.request.builder.FlightCriteriaDTOBuilder
import edu.fiuba.reservations.delivery.dto.response.FlightSearchListDTO
import edu.fiuba.reservations.delivery.dto.response.FlightSearchListDTO.FlightSearchDTO
import edu.fiuba.reservations.delivery.validator.FlightCriteriaDTOValidator
import edu.fiuba.reservations.infrastructure.service.FlightService

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
}
