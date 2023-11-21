package edu.fiuba.reservations.utils

import java.time.ZonedDateTime

inline fun <T : Any, R> T?.ifNotNull(callback: (T) -> R): R? {
    return this?.let(callback)
}

inline fun <T, R> T?.ifNotNullAndBlank(callback: (T) -> R): R? where T : String? {
    return if (isNotNullAndBlank()) this?.let(callback) else null
}

fun Any?.isNull(): Boolean {
    return this == null
}

fun String?.isNotNullAndBlank(): Boolean {
    return this.isNullOrBlank().not()
}

fun ZonedDateTime.isBetweenDates(from: ZonedDateTime, to: ZonedDateTime): Boolean {
    return this > from && this < to
}
