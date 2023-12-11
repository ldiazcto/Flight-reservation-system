package edu.fiuba.reservations.domain.validator

import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateDateTimeException
import edu.fiuba.reservations.utils.validator.Validator
import java.time.ZonedDateTime

class DateTimeValidator : Validator<Pair<ZonedDateTime?, ZonedDateTime?>> {
    override fun validate(data: Pair<ZonedDateTime?, ZonedDateTime?>, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        val (actualDate, flightDate) = data

        actualDate?.let { actual ->
            flightDate?.let { flight ->
                if (actual > flight) {
                    exceptions.add(generateDateTimeException(fieldNames))
                }
            }
        }

        return exceptions
    }
}
