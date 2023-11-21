package edu.fiuba.reservations.application.exception

import edu.fiuba.reservations.utils.enums.Exception

enum class ExceptionCode(
    private val code: String,
    private val message: String
) : Exception {
    INVALID_FLIGHT_CRITERIA("error.fields", "The flight criteria provided is not valid");

    override fun getCode(): String = code
    override fun getMessage(): String = message
}
