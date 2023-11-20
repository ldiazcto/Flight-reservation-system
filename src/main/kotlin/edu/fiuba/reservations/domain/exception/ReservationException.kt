package edu.fiuba.reservations.domain.exception

import edu.fiuba.reservations.domain.entity.Error
import org.springframework.http.HttpStatus
import java.lang.RuntimeException

open class ReservationException(
    override val message: String,
    open var code: String,
    open var status: Int,
    open var errors: List<Error>
) : RuntimeException() {
    constructor() : this(String(), String(), HttpStatus.INTERNAL_SERVER_ERROR.value(), listOf())
}
