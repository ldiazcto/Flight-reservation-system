package edu.fiuba.reservations.domain.exception

import edu.fiuba.reservations.domain.entity.Error
import org.springframework.http.HttpStatus

class BadRequestException(
    override var message: String,
    override var code: String,
    override var errors: List<Error>
) : ReservationException(message, code, HttpStatus.BAD_REQUEST.value(), errors)
