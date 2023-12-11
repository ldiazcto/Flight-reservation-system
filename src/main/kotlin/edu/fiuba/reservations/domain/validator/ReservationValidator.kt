package edu.fiuba.reservations.domain.validator

import edu.fiuba.reservations.delivery.dto.request.CreateReservationDTO
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.fromCode
import edu.fiuba.reservations.utils.Constants.DATETIME_RFC3339_PATTERN
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateAirlineCodeException
import edu.fiuba.reservations.utils.getCurrentDateTime
import edu.fiuba.reservations.utils.toDateFromPatternWithHours
import edu.fiuba.reservations.utils.validator.Validator

class ReservationValidator : BaseValidator(), Validator<CreateReservationDTO> {
    override fun validate(data: CreateReservationDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        val actualDate = getCurrentDateTime().toDateFromPatternWithHours(DATETIME_RFC3339_PATTERN)
        val flightDate = data.flightDate?.toDateFromPatternWithHours(DATETIME_RFC3339_PATTERN)

        exceptions.addAll(
            dateTimeValidator.validate(
                data = Pair(actualDate, flightDate),
                fieldNames = fieldNames.plus(CreateReservationDTO::flightDate.name)
            )
        )

        if (AirlineCode.fromCode(data.airline!!) == AirlineCode.ALL) {
            exceptions.add(
                generateAirlineCodeException(
                    fieldNames = fieldNames.plus(CreateReservationDTO::airline.name)
                )
            )
        }

        exceptions.addAll(
            destinationValidator.validate(
                data = Pair(data.origin!!, data.destination!!),
                fieldNames = fieldNames.plus(CreateReservationDTO::destination.name)
            )
        )

        return exceptions
    }
}
