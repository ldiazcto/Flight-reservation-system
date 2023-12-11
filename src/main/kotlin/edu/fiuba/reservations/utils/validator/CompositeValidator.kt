package edu.fiuba.reservations.utils.validator

import edu.fiuba.reservations.utils.enums.Exception

class CompositeValidator<T>(
    private val validators: List<Validator<T>>
) : Validator<T> {

    override fun validate(data: T, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        validators.forEach { exceptions.addAll(it.validate(data, fieldNames)) }

        return exceptions
    }
}
