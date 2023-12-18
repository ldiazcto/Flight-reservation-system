package edu.fiuba.reservations.application.config

import edu.fiuba.reservations.delivery.controller.FlightController
import edu.fiuba.reservations.infrastructure.client.file.FlightFileManager
import edu.fiuba.reservations.infrastructure.service.FlightService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FlightConfiguration {
    @Bean
    fun flightController(
        flightService: FlightService
    ): FlightController {
        return FlightController(
            flightService
        )
    }

    @Bean
    fun flightFileManager(
        @Value("\${data.csv.flights.paths}") filePaths: ArrayList<String>
    ): FlightFileManager {
        return FlightFileManager(
            filePaths
        )
    }
}
