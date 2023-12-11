package edu.fiuba.reservations.domain.validator

import edu.fiuba.reservations.delivery.dto.response.CustomerDTO
import edu.fiuba.reservations.delivery.dto.response.PhoneDTO
import edu.fiuba.reservations.delivery.validator.BaseValidator
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.validator.CompositeValidator
import edu.fiuba.reservations.utils.validator.Validator

class CustomerValidator : BaseValidator(), Validator<CustomerDTO> {
    override fun validate(data: CustomerDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        setPhoneExceptions(
            data = data.phone!!,
            fieldNames = fieldNames.plus(CustomerDTO::phone.name),
            exceptions = exceptions
        )

        return exceptions
    }

    private fun setPhoneExceptions(data: PhoneDTO, fieldNames: List<String>, exceptions: ArrayList<Exception>) {
        val validators = ArrayList<Validator<PhoneDTO>>()
        validators.add(PhoneValidator())

        val phoneValidator = CompositeValidator(validators)
        exceptions.addAll(phoneValidator.validate(data, fieldNames))
    }
}
