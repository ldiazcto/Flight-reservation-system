package edu.fiuba.reservations.utils

import edu.fiuba.reservations.logger
import edu.fiuba.reservations.utils.Constants.ARGENTINE_ZONE
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.toDateFromPatternWithHours(pattern: String): ZonedDateTime? {
    val log by logger()

    return try {
        val timeFormatter = DateTimeFormatter.ofPattern(pattern).apply {
            withZone(ZoneId.of(ARGENTINE_ZONE))
        }

        val localDate = LocalDateTime.parse(this, timeFormatter)

        // Convert date to Argentina's time
        val zonedDateTime = ZonedDateTime.of(localDate, ZoneId.of(ARGENTINE_ZONE))

        // Convert date to UTC
        return zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"))
    } catch (e: Exception) {
        log.warn("Error converting string to date. String: $this")
        null
    }
}
