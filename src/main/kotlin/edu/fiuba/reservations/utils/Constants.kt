package edu.fiuba.reservations.utils

object Constants {
    const val ARGENTINE_ZONE = "America/Buenos_Aires"
    const val ARGENTINE_TIME_ZONE = "GMT-3"
    const val DATE_PATTERN = "yyyy-MM-dd"
    const val DATETIME_RFC3339_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
    const val DATETIME_PATTERN = "yyyy-MM-dd-HH.mm.ss.SSSSSS"
    const val FLIGHT_ID_LENGTH = 8
    const val RESERVATION_ID_LENGTH = 6
    val INTEGER_REGEX = """^\d+${'$'}""".toRegex()
    val DOUBLE_REGEX = """^[0-9]+\.[0-9]{1,2}${'$'}""".toRegex()
    val EMAIL_REGEX = """^[\w-\\.]+@([\w-]+\.)+[\w-]{2,4}${'$'}""".toRegex()
}
