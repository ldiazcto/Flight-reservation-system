package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.delivery.dto.response.CustomerDTO
import edu.fiuba.reservations.delivery.dto.response.DocumentDTO
import edu.fiuba.reservations.delivery.dto.response.PhoneDTO
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateRequiredFieldException
import edu.fiuba.reservations.utils.ifNotNull
import edu.fiuba.reservations.utils.ifNotNullAndBlank
import edu.fiuba.reservations.utils.isNull
import edu.fiuba.reservations.utils.validator.CompositeValidator
import edu.fiuba.reservations.utils.validator.Validator

class CustomerDTOValidator : BaseValidator(), Validator<CustomerDTO> {
    override fun validate(data: CustomerDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        exceptions.addAll(
            validateRequiredFields(data, fieldNames)
        )

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

    private fun validateRequiredFields(data: CustomerDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (data.firstName.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CustomerDTO::firstName.name))
            )
        }

        if (data.lastName.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CustomerDTO::lastName.name))
            )
        }

        if (data.documents.isNullOrEmpty()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CustomerDTO::documents.name))
            )
        }

        if (data.email.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CustomerDTO::email.name))
            )
        }

        if (data.phone.isNull()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CustomerDTO::phone.name))
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
