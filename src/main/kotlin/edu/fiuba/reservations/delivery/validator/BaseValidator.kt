package edu.fiuba.reservations.delivery.validator

abstract class BaseValidator {
    protected val enumValidator = EnumValidator()
    protected val dateValidator = DateValidator()
}
