package edu.fiuba.reservations.utils

import edu.fiuba.reservations.delivery.exception.ExceptionCode
import edu.fiuba.reservations.utils.Constants.DATE_PATTERN
import edu.fiuba.reservations.utils.enums.Exception
import java.text.MessageFormat

private const val requiredFieldCodeTemplate = "required.field.{0}"
private const val invalidValueCodeTemplate = "invalid.value.{0}"
private const val requiredFieldMessageTemplate = "The {0} field is required"
private const val invalidTypeValueMessageTemplate = "The {0} type provided does not match with any existing type"
private const val invalidDateFormatMessageTemplate = "The {0} does not have the date format $DATE_PATTERN"
private const val invalidDatesRangeMessageTemplate = "The {0} date is major than to date"
private const val invalidDestinationMessageTemplate = "The {0} can not be the same as the origin"

fun generateRequiredFieldException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(requiredFieldCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(requiredFieldMessageTemplate, fieldNames.last())
    )
}

fun generateEnumException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidTypeValueMessageTemplate, fieldNames.last())
    )
}

fun generateDateException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidDateFormatMessageTemplate, fieldNames.last())
    )
}

fun generateDatesRangeException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidDatesRangeMessageTemplate, fieldNames.last())
    )
}

fun generateDestinationException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidDestinationMessageTemplate, fieldNames.last())
    )
}
