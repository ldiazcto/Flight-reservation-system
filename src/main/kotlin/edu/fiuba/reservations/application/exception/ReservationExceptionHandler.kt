package edu.fiuba.reservations.application.exception

import edu.fiuba.reservations.domain.entity.ApiError
import edu.fiuba.reservations.domain.exception.ReservationException
import edu.fiuba.reservations.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ReservationExceptionHandler : ResponseEntityExceptionHandler() {
    private val log by logger()

    @ExceptionHandler(value = [(ReservationException::class)])
    fun handleCustomerException(
        ex: ReservationException,
        request: WebRequest
    ): ResponseEntity<ApiError> {
        val errorDetails = ApiError(ex.code, ex.message, ex.errors)

        log.error("Exception thrown - CODE: ${ex.code}  MESSAGE: \"${ex.message}\" STATUS: ${ex.status}", ex)

        ex.stackTrace.take(4).map { e ->
            log.error(e.toString())
        }

        return ResponseEntity(errorDetails, HttpStatus.valueOf(ex.status))
    }
}
