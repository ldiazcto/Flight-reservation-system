package edu.fiuba.reservations.application.exception

import edu.fiuba.reservations.utils.enums.Exception

enum class ExceptionCode(
    private val code: String,
    private val message: String
) : Exception {
    FLIGHT_NOT_FOUND("flight.not.found", "The flight was not found"),
    INVALID_FLIGHT_CRITERIA("error.fields", "The flight criteria provided is not valid");

    override fun getCode(): String = code
    override fun getMessage(): String = message
}
