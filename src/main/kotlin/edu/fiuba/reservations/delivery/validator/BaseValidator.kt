package edu.fiuba.reservations.delivery.validator

abstract class BaseValidator {
    protected val dateValidator = DateValidator()
    protected val dateTimeValidator = DateTimeValidator()
    protected val doubleValidator = DoubleValidator()
    protected val emailValidator = EmailValidator()
    protected val enumValidator = EnumValidator()
    protected val integerValidator = IntegerValidator()
}
