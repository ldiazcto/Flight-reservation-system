package edu.fiuba.reservations.domain.validator

import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateDatesRangeException
import edu.fiuba.reservations.utils.validator.Validator
import java.time.ZonedDateTime

class DateValidator : Validator<Pair<ZonedDateTime?, ZonedDateTime?>> {
    override fun validate(data: Pair<ZonedDateTime?, ZonedDateTime?>, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        val (fromDate, toDate) = data

        fromDate?.let { from ->
            toDate?.let { to ->
                if (from > to) {
                    exceptions.add(generateDatesRangeException(fieldNames))
                }
            } ?: run {
                exceptions.add(generateDatesRangeException(fieldNames))
            }
        }

        return exceptions
    }
}
