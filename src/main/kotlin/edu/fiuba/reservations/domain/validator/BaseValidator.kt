package edu.fiuba.reservations.domain.validator

abstract class BaseValidator {
    protected val destinationValidator = DestinationValidator()
    protected val dateValidator = DateValidator()
}
