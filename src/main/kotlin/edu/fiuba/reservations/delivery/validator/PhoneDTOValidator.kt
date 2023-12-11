package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.delivery.dto.response.PhoneDTO
import edu.fiuba.reservations.domain.enums.PhoneType
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.ifNotNullAndBlank
import edu.fiuba.reservations.utils.validator.Validator

class PhoneDTOValidator : BaseValidator(), Validator<PhoneDTO> {
    override fun validate(data: PhoneDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        data.type.ifNotNullAndBlank {
            exceptions.addAll(
                enumValidator.validate(
                    data = Pair(it, PhoneType::class),
                    fieldNames = fieldNames.plus(PhoneDTO::type.name)
                )
            )
        }

        data.areaCode.ifNotNullAndBlank {
            exceptions.addAll(
                integerValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(PhoneDTO::areaCode.name)
                )
            )
        }

        data.number.ifNotNullAndBlank {
            exceptions.addAll(
                integerValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(PhoneDTO::number.name)
                )
            )
        }

        return exceptions
    }
}
