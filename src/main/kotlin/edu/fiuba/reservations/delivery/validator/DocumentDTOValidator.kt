package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.delivery.dto.response.DocumentDTO
import edu.fiuba.reservations.domain.enums.DocumentType
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateRequiredFieldException
import edu.fiuba.reservations.utils.ifNotNullAndBlank
import edu.fiuba.reservations.utils.validator.Validator

class DocumentDTOValidator : BaseValidator(), Validator<DocumentDTO> {
    override fun validate(data: DocumentDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        exceptions.addAll(
            validateRequiredFields(data, fieldNames)
        )

        data.type.ifNotNullAndBlank {
            exceptions.addAll(
                enumValidator.validate(
                    data = Pair(it, DocumentType::class),
                    fieldNames = fieldNames.plus(DocumentDTO::type.name)
                )
            )
        }

        data.number.ifNotNullAndBlank {
            exceptions.addAll(
                integerValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(DocumentDTO::number.name)
                )
            )
        }

        return exceptions
    }

    private fun validateRequiredFields(data: DocumentDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (data.type.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(DocumentDTO::type.name))
            )
        }

        if (data.number.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(DocumentDTO::number.name))
            )
        }

        return exceptions
    }
}
