package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateEnumException
import edu.fiuba.reservations.utils.validator.Validator
import kotlin.reflect.KClass

class EnumValidator : Validator<Pair<String, KClass<out Enum<*>>>> {
    private val acceptedValues: MutableList<String> = mutableListOf()

    override fun validate(data: Pair<String, KClass<out Enum<*>>>, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (isNotValid(data)) {
            exceptions.add(generateEnumException(fieldNames))
        }

        return exceptions
    }

    private fun isNotValid(data: Pair<String, KClass<out Enum<*>>>): Boolean {
        return isValid(data).not()
    }

    private fun isValid(data: Pair<String, KClass<out Enum<*>>>): Boolean {
        acceptedValues.addAll(
            data.second.java.enumConstants.map { it.name }
        )

        return acceptedValues.contains(data.first.uppercase())
    }
}
