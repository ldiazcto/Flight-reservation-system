package edu.fiuba.flightreservationsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlightReservationsApiApplication

fun main(args: Array<String>) {
	runApplication<FlightReservationsApiApplication>(*args)
}
