package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.delivery.dto.request.FlightCriteriaDTO
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateRequiredFieldException
import edu.fiuba.reservations.utils.ifNotNullAndBlank
import edu.fiuba.reservations.utils.validator.Validator

class FlightCriteriaDTOValidator : BaseValidator(), Validator<FlightCriteriaDTO> {
    override fun validate(data: FlightCriteriaDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        exceptions.addAll(
            validateRequiredFields(data, fieldNames)
        )

        data.airline.ifNotNullAndBlank {
            exceptions.addAll(
                enumValidator.validate(
                    data = Pair(it, AirlineCode::class),
                    fieldNames = fieldNames.plus(FlightCriteriaDTO::airline.name)
                )
            )
        }

        data.from.ifNotNullAndBlank {
            exceptions.addAll(
                dateValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(FlightCriteriaDTO::from.name)
                )
            )
        }

        data.to.ifNotNullAndBlank {
            exceptions.addAll(
                dateValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(FlightCriteriaDTO::to.name)
                )
            )
        }

        return exceptions
    }

    private fun validateRequiredFields(data: FlightCriteriaDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (data.to.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(FlightCriteriaDTO::to.name))
            )
        }

        return exceptions
    }
}
