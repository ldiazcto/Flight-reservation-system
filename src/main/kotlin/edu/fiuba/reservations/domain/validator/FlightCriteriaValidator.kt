package edu.fiuba.reservations.domain.validator

import edu.fiuba.reservations.delivery.dto.request.FlightCriteriaDTO
import edu.fiuba.reservations.utils.Constants.DATE_PATTERN
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.toDateFromPatternWithoutHours
import edu.fiuba.reservations.utils.validator.Validator

class FlightCriteriaValidator : BaseValidator(), Validator<FlightCriteriaDTO> {
    override fun validate(data: FlightCriteriaDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        val fromDate = data.from?.toDateFromPatternWithoutHours(DATE_PATTERN)
        val toDate = data.to?.toDateFromPatternWithoutHours(DATE_PATTERN)

        exceptions.addAll(
            dateValidator.validate(
                data = Pair(fromDate, toDate),
                fieldNames = fieldNames.plus(FlightCriteriaDTO::from.name)
            )
        )

        return exceptions
    }
}
