package edu.fiuba.reservations

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ReservationsApplication

fun main(args: Array<String>) {
	runApplication<ReservationsApplication>(*args)
}
