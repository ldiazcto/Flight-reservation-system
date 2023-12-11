package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.utils.Constants.INTEGER_REGEX
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateIntegerException
import edu.fiuba.reservations.utils.validator.Validator

class IntegerValidator : Validator<String> {
    override fun validate(data: String, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (isNotValid(data)) {
            exceptions.add(generateIntegerException(fieldNames))
        }

        return exceptions
    }

    private fun isNotValid(data: String): Boolean {
        return isValid(data).not()
    }

    private fun isValid(data: String): Boolean {
        return INTEGER_REGEX.containsMatchIn(data)
    }
}
