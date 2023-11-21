package edu.fiuba.reservations.infrastructure.client.file

import edu.fiuba.reservations.domain.entity.FlightCriteria
import edu.fiuba.reservations.domain.entity.FlightSearch
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.fromValue
import edu.fiuba.reservations.logger
import edu.fiuba.reservations.utils.ifNotNull
import edu.fiuba.reservations.utils.isBetweenDates
import org.apache.commons.csv.CSVFormat
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.time.ZonedDateTime

class FlightFileManager(
    private val filePath: String
) {
    private val log by logger()

    fun getFlights(flightCriteria: FlightCriteria): List<FlightSearch> {
        val flights = readFile().filter {
            isSameAirline(flightCriteria.airline!!, it.airline) &&
                it.departureTime.isBetweenDates(flightCriteria.from!!, flightCriteria.to!!) &&
                it.arrivalTime.isBetweenDates(flightCriteria.from, flightCriteria.to)
        }

        return flights
    }

    private fun readFile(): List<FlightSearch> {
        var flights: List<FlightSearch> = listOf()
        var inputStream: InputStream? = null
        val classLoader = javaClass.getClassLoader()

        try {
            val file = File(classLoader.getResource(filePath)?.file ?: String())
            inputStream = FileInputStream(file)

            flights = processCsv(inputStream)
        } catch (e: FileNotFoundException) {
            log.error("Threw a FileNotFoundException in FlightFileManager::getFlights", e)
        }

        inputStream.ifNotNull {
            try {
                inputStream?.close()
            } catch (e: IOException) {
                log.error("Threw a IOException in FlightFileManager::getFlights", e)
            }
        }

        return flights
    }

    private fun processCsv(inputStream: InputStream): List<FlightSearch> {
        val csvParser = CSVFormat.Builder.create(CSVFormat.DEFAULT).apply {
            setHeader()
            setSkipHeaderRecord(true)
        }.build().parse(inputStream.reader())

        return csvParser.map {
            FlightSearch(
                id = it.first(),
                airline = AirlineCode.fromValue(it[1].replace(" ", "_"))!!,
                departureTime = ZonedDateTime.parse(it[3]),
                arrivalTime = ZonedDateTime.parse(it[5]),
                originAirport = it[8],
                destinationAirport = it[12]
            )
        }
    }

    private fun isSameAirline(expected: AirlineCode, actual: AirlineCode): Boolean {
        if (expected == AirlineCode.ALL) {
            return true
        }

        return expected == actual
    }
}
