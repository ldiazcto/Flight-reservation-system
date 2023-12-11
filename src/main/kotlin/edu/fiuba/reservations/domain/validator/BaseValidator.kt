package edu.fiuba.reservations.domain.validator

abstract class BaseValidator {
    protected val dateValidator = DateValidator()
    protected val dateTimeValidator = DateTimeValidator()
    protected val destinationValidator = DestinationValidator()
}
