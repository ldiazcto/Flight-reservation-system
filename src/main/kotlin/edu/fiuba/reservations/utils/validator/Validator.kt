package edu.fiuba.reservations.utils.validator

import edu.fiuba.reservations.utils.enums.Exception

interface Validator<T> {
    fun validate(data: T, fieldNames: List<String>): List<Exception>
}
