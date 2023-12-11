package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.logger
import edu.fiuba.reservations.utils.Constants.ARGENTINE_TIME_ZONE
import edu.fiuba.reservations.utils.Constants.DATETIME_RFC3339_PATTERN
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateDateException
import edu.fiuba.reservations.utils.validator.Validator
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class DateTimeValidator : Validator<String> {
    private val log by logger()
    private val formatter = DateTimeFormatter.ofPattern(DATETIME_RFC3339_PATTERN)

    override fun validate(data: String, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (isNotValid(data)) {
            exceptions.add(generateDateException(fieldNames))
        }

        return exceptions
    }

    private fun isNotValid(data: String): Boolean {
        return isValid(data).not()
    }

    private fun isValid(data: String): Boolean {
        formatter.withZone(ZoneId.of(ARGENTINE_TIME_ZONE))

        try {
            val localDateTime = LocalDateTime.parse(data, formatter)
            val zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(ARGENTINE_TIME_ZONE))
            val result = zonedDateTime.format(formatter)

            return result.equals(data)
        } catch (e: java.lang.Exception) {
            log.error("Date time '$data' does not have $DATETIME_RFC3339_PATTERN format", e)
        }

        return false
    }
}
