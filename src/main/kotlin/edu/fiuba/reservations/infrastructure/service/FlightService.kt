package edu.fiuba.reservations.infrastructure.service

import edu.fiuba.reservations.delivery.dto.request.FlightCriteriaDTO
import edu.fiuba.reservations.domain.entity.Flight
import edu.fiuba.reservations.domain.entity.FlightSearch
import edu.fiuba.reservations.domain.entity.builder.FlightCriteriaBuilder
import edu.fiuba.reservations.domain.validator.FlightCriteriaValidator
import edu.fiuba.reservations.infrastructure.client.file.FlightFileManager
import org.springframework.stereotype.Service

@Service
class FlightService(
    private val flightFileManager: FlightFileManager
) {
    fun getFlights(flightCriteria: FlightCriteriaDTO): List<FlightSearch> {
        val validatedFlightCriteria = FlightCriteriaBuilder(FlightCriteriaValidator()).build(flightCriteria)

        return flightFileManager.getFlights(validatedFlightCriteria)
    }

    fun getFlight(id: String): Flight {
        return flightFileManager.getFlight(id)
    }
}
