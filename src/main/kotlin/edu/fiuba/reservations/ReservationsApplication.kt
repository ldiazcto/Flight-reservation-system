package edu.fiuba.reservations

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ReservationsApplication

fun main(args: Array<String>) {
	runApplication<ReservationsApplication>(*args)
}

fun <R : Any> R.logger(): Lazy<Logger> {
	return lazy { LoggerFactory.getLogger(this.javaClass) }
}
