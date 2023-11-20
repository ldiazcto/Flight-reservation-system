package edu.fiuba.reservations.application.controller

import edu.fiuba.reservations.delivery.controller.FlightController
import edu.fiuba.reservations.delivery.dto.request.FlightCriteriaDTO
import edu.fiuba.reservations.delivery.dto.response.FlightSearchListDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("flights")
class FlightResource(
    private val flightController: FlightController
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getFlights(
        flightCriteria: FlightCriteriaDTO
    ): FlightSearchListDTO {
        return flightController.getFlights(flightCriteria)
    }
}
