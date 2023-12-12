package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.delivery.dto.request.UpdateReservationDTO
import edu.fiuba.reservations.delivery.dto.response.CustomerDTO
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.ifNotNull
import edu.fiuba.reservations.utils.ifNotNullAndBlank
import edu.fiuba.reservations.utils.validator.CompositeValidator
import edu.fiuba.reservations.utils.validator.Validator

class UpdateReservationDTOValidator : BaseValidator(), Validator<UpdateReservationDTO> {
    override fun validate(data: UpdateReservationDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        data.flightDate.ifNotNullAndBlank {
            exceptions.addAll(
                dateTimeValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(UpdateReservationDTO::flightDate.name)
                )
            )
        }

        data.passengersQuantity.ifNotNullAndBlank {
            exceptions.addAll(
                integerValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(UpdateReservationDTO::passengersQuantity.name)
                )
            )
        }

        data.totalPrice.ifNotNullAndBlank {
            exceptions.addAll(
                doubleValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(UpdateReservationDTO::totalPrice.name)
                )
            )
        }

        data.customer.ifNotNull {
            setCustomerExceptions(
                data = it,
                fieldNames = fieldNames.plus(UpdateReservationDTO::customer.name),
                exceptions = exceptions
            )
        }

        return exceptions
    }

    private fun setCustomerExceptions(data: CustomerDTO, fieldNames: List<String>, exceptions: ArrayList<Exception>) {
        val validators = ArrayList<Validator<CustomerDTO>>()
        validators.add(CustomerDTOValidator())

        val customerValidator = CompositeValidator(validators)
        exceptions.addAll(customerValidator.validate(data, fieldNames))
    }
}
