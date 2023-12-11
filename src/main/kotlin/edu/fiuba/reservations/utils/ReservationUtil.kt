package edu.fiuba.reservations.utils

import edu.fiuba.reservations.logger
import edu.fiuba.reservations.utils.Constants.ARGENTINE_TIME_ZONE
import edu.fiuba.reservations.utils.Constants.ARGENTINE_ZONE
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.toDateFromPatternWithoutHours(pattern: String): ZonedDateTime? {
    val log by logger()

    return try {
        val timeFormatter = DateTimeFormatter.ofPattern(pattern)
            .withZone(ZoneId.of(ARGENTINE_TIME_ZONE))

        val localDate = LocalDate.parse(this, timeFormatter)

        // Set time
        val zeroTimeLocalDate = localDate.atStartOfDay()

        // Convert date to Argentina's time
        val zonedDateTime = ZonedDateTime.of(zeroTimeLocalDate, ZoneId.of(ARGENTINE_TIME_ZONE))

        // Convert date to UTC
        zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"))
    } catch (e: Exception) {
        log.warn("Error converting string to date. String: $this")
        null
    }
}

fun String.toDateFromPatternWithHours(pattern: String): ZonedDateTime? {
    val log by logger()

    return try {
        val timeFormatter = DateTimeFormatter.ofPattern(pattern)
            .withZone(ZoneId.of(ARGENTINE_ZONE))

        val localDate = LocalDateTime.parse(this, timeFormatter)

        // Convert date to Argentina's time
        val zonedDateTime = ZonedDateTime.of(localDate, ZoneId.of(ARGENTINE_ZONE))

        // Convert date to UTC
        zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"))
    } catch (e: Exception) {
        log.warn("Error converting string to date. String: $this")
        null
    }
}

fun ZonedDateTime.formatToString(pattern: String): String {
    return DateTimeFormatter.ofPattern(pattern).format(this.withZoneSameInstant(ZoneId.of(ARGENTINE_ZONE)))
}

fun String.toCustomBigDecimal(): BigDecimal {
    val value = BigDecimal(substring(0, lastIndex)).movePointLeft(2)

    return when (this[lastIndex]) {
        '+' -> value
        '-' -> value.multiply(BigDecimal.ONE.negate())
        else -> value
    }
}

fun getCurrentDate(): String {
    val formatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN).apply {
        withZone(ZoneId.of(ARGENTINE_TIME_ZONE))
    }

    val localDateTime = LocalDate.now(ZoneId.of(ARGENTINE_TIME_ZONE)).atStartOfDay()

    return localDateTime.format(formatter)
}
