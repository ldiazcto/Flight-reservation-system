package edu.fiuba.reservations.domain.exception

import edu.fiuba.reservations.domain.entity.Error
import org.springframework.http.HttpStatus

class ResourceNotFoundException(
    override var message: String,
    override var errors: List<Error>
) : ReservationException(
    message,
    "not.found",
    HttpStatus.NOT_FOUND.value(),
    errors
)
