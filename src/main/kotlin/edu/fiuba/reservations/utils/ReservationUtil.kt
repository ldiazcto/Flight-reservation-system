package edu.fiuba.reservations.utils

import edu.fiuba.reservations.logger
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

const val ZONE = "America/Buenos_Aires"
const val DATE_TIME_ZONE = "GMT-3"
const val RFC3339PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
const val YYYY_MM_DD_HH_MM_SS_SSSS = "yyyy-MM-dd-HH.mm.ss.SSSSSS"

fun String.toDateFromPatternWithHours(pattern: String): ZonedDateTime? {
    val log by logger()

    return try {
        val timeFormatter = DateTimeFormatter.ofPattern(pattern).apply {
            withZone(ZoneId.of(ZONE))
        }

        val localDate = LocalDateTime.parse(this, timeFormatter)

        // Convert date to Argentina's time
        val zonedDateTime = ZonedDateTime.of(localDate, ZoneId.of(ZONE))

        // Convert date to UTC
        return zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"))
    } catch (e: Exception) {
        log.warn("Error converting string to date. String: $this")
        null
    }
}
