package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.delivery.dto.response.CustomerDTO
import edu.fiuba.reservations.delivery.dto.response.DocumentDTO
import edu.fiuba.reservations.delivery.dto.response.PhoneDTO
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.ifNotNull
import edu.fiuba.reservations.utils.ifNotNullAndBlank
import edu.fiuba.reservations.utils.validator.CompositeValidator
import edu.fiuba.reservations.utils.validator.Validator

class CustomerDTOValidator : BaseValidator(), Validator<CustomerDTO> {
    override fun validate(data: CustomerDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        data.documents?.forEach {
            setDocumentExceptions(
                data = it,
                fieldNames = fieldNames.plus(CustomerDTO::documents.name),
                exceptions = exceptions
            )
        }

        data.email.ifNotNullAndBlank {
            exceptions.addAll(
                emailValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(CustomerDTO::email.name)
                )
            )
        }

        data.phone.ifNotNull {
            setPhoneExceptions(
                data = it,
                fieldNames = fieldNames.plus(CustomerDTO::phone.name),
                exceptions = exceptions
            )
        }

        return exceptions
    }

    private fun setDocumentExceptions(data: DocumentDTO, fieldNames: List<String>, exceptions: ArrayList<Exception>) {
        val validators = ArrayList<Validator<DocumentDTO>>()
        validators.add(DocumentDTOValidator())

        val documentValidator = CompositeValidator(validators)
        exceptions.addAll(documentValidator.validate(data, fieldNames))
    }

    private fun setPhoneExceptions(data: PhoneDTO, fieldNames: List<String>, exceptions: ArrayList<Exception>) {
        val validators = ArrayList<Validator<PhoneDTO>>()
        validators.add(PhoneDTOValidator())

        val phoneValidator = CompositeValidator(validators)
        exceptions.addAll(phoneValidator.validate(data, fieldNames))
    }
}
