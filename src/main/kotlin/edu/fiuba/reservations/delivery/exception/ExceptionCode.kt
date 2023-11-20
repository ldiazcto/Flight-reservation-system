package edu.fiuba.reservations.delivery.exception

import edu.fiuba.reservations.utils.enums.Exception

class ExceptionCode(
    private val code: String,
    private val message: String
) : Exception {
    override fun getCode(): String = code

    override fun getMessage(): String = message
}
