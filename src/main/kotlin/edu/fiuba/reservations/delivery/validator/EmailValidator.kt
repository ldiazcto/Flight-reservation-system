package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.utils.Constants.EMAIL_REGEX
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateEmailException
import edu.fiuba.reservations.utils.validator.Validator

class EmailValidator : Validator<String> {
    override fun validate(data: String, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (isNotValid(data)) {
            exceptions.add(generateEmailException(fieldNames))
        }

        return exceptions
    }

    private fun isNotValid(data: String): Boolean {
        return isValid(data).not()
    }

    private fun isValid(data: String): Boolean {
        return EMAIL_REGEX.containsMatchIn(data)
    }
}
