package edu.fiuba.reservations.utils

import edu.fiuba.reservations.delivery.exception.ExceptionCode
import edu.fiuba.reservations.utils.Constants.DATE_PATTERN
import edu.fiuba.reservations.utils.enums.Exception
import java.text.MessageFormat

private const val requiredFieldCodeTemplate = "required.field.{0}"
private const val invalidValueCodeTemplate = "invalid.value.{0}"
private const val requiredFieldMessageTemplate = "The ''{0}'' field is required"
private const val invalidTypeValueMessageTemplate = "The ''{0}'' type provided does not match with any existing type"
private const val invalidDateFormatMessageTemplate = "The ''{0}'' does not have the date format $DATE_PATTERN"
private const val invalidDatesRangeMessageTemplate = "The ''{0}'' date is major than ''to'' date"
private const val invalidDestinationMessageTemplate = "The ''{0}'' can not be the same as the origin"
private const val invalidIntegerValueMessageTemplate = "The ''{0}'' provided must be a positive integer number"
private const val invalidDoubleValueMessageTemplate = "The ''{0}'' provided must be a positive double number"
private const val invalidEmailValueMessageTemplate = "The ''{0}'' provided must be in the format of a valid email"
private const val invalidDateTimeMessageTemplate = "The ''{0}'' is less than actual date time"
private const val invalidAirlineCodeValueMessageTemplate = "The ''{0}'' type provided is not valid for reservations"
private const val invalidAreaCodeValueMessageTemplate = "The ''{0}'' provided must be began with 0"
private const val invalidAreaCodeLengthValueMessageTemplate = "The ''{0}'' provided must be between 2 and 5 characters"
private const val invalidCompletePhoneNumberMessageTemplate = "The complete phone {0} provided must be 12 characters"

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

fun generateIntegerException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidIntegerValueMessageTemplate, fieldNames.last())
    )
}

fun generateDoubleException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidDoubleValueMessageTemplate, fieldNames.last())
    )
}

fun generateEmailException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidEmailValueMessageTemplate, fieldNames.last())
    )
}

fun generateDateTimeException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidDateTimeMessageTemplate, fieldNames.last())
    )
}

fun generateAirlineCodeException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidAirlineCodeValueMessageTemplate, fieldNames.last())
    )
}

fun generateAreaCodeException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidAreaCodeValueMessageTemplate, fieldNames.last())
    )
}

fun generateAreaCodeLengthException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidAreaCodeLengthValueMessageTemplate, fieldNames.last())
    )
}

fun generateCompletePhoneNumberException(fieldNames: List<String>): Exception {
    return ExceptionCode(
        MessageFormat.format(invalidValueCodeTemplate, fieldNames.joinToString(".")),
        MessageFormat.format(invalidCompletePhoneNumberMessageTemplate, fieldNames.last())
    )
}
