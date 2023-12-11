package edu.fiuba.reservations.domain.validator

import edu.fiuba.reservations.delivery.dto.response.PhoneDTO
import edu.fiuba.reservations.delivery.validator.BaseValidator
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateAreaCodeException
import edu.fiuba.reservations.utils.generateAreaCodeLengthException
import edu.fiuba.reservations.utils.generateCompletePhoneNumberException
import edu.fiuba.reservations.utils.validator.Validator

class PhoneValidator : BaseValidator(), Validator<PhoneDTO> {
    override fun validate(data: PhoneDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (data.areaCode!!.first() != '0') {
            exceptions.add(
                generateAreaCodeException(
                    fieldNames = fieldNames.plus(PhoneDTO::areaCode.name)
                )
            )
        }

        if ((data.areaCode.length in 2..5).not()) {
            exceptions.add(
                generateAreaCodeLengthException(
                    fieldNames = fieldNames.plus(PhoneDTO::areaCode.name)
                )
            )
        }

        if ((data.areaCode + data.number).length > 12) {
            exceptions.add(
                generateCompletePhoneNumberException(
                    fieldNames = fieldNames.plus(PhoneDTO::number.name)
                )
            )
        }

        return exceptions
    }
}
