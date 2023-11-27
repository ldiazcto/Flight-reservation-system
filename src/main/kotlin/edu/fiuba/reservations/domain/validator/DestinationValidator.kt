package edu.fiuba.reservations.domain.validator

import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateDestinationException
import edu.fiuba.reservations.utils.validator.Validator

class DestinationValidator : Validator<Pair<String, String>> {
    override fun validate(data: Pair<String, String>, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (isNotValid(data)) {
            exceptions.add(generateDestinationException(fieldNames))
        }

        return exceptions
    }

    private fun isNotValid(data: Pair<String, String>): Boolean {
        return isValid(data).not()
    }

    private fun isValid(data: Pair<String, String>): Boolean {
        val (origin, destination) = data

        return origin != destination
    }
}
