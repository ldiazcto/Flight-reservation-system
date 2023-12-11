package edu.fiuba.reservations.application.exception

import edu.fiuba.reservations.utils.enums.Exception

enum class ExceptionCode(
    private val code: String,
    private val message: String
) : Exception {
    FLIGHT_NOT_FOUND("flight.not.found", "The flight was not found"),
    INVALID_FLIGHT_CRITERIA("error.params", "The flight criteria provided is not valid"),
    INVALID_FLIGHT_ID("error.params", "The flight id provided is not valid, its length must be 8 characters"),
    INVALID_RESERVATION_ID("error.params", "The reservation id provided is not valid, its length must be 6 characters"),
    INVALID_RESERVATION_BODY("error.fields", "The reservation provided is not valid"),
    DATABASE_INTERNAL_ERROR("internal.error", "There was an error at operating with the database");

    override fun getCode(): String = code
    override fun getMessage(): String = message
}
