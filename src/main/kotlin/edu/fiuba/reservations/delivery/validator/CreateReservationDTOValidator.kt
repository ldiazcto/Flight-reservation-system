package edu.fiuba.reservations.delivery.validator

import edu.fiuba.reservations.delivery.dto.request.CreateReservationDTO
import edu.fiuba.reservations.delivery.dto.response.CustomerDTO
import edu.fiuba.reservations.domain.enums.AirlineCode
import edu.fiuba.reservations.domain.enums.AirportCode
import edu.fiuba.reservations.utils.enums.Exception
import edu.fiuba.reservations.utils.generateRequiredFieldException
import edu.fiuba.reservations.utils.ifNotNull
import edu.fiuba.reservations.utils.ifNotNullAndBlank
import edu.fiuba.reservations.utils.isNull
import edu.fiuba.reservations.utils.validator.CompositeValidator
import edu.fiuba.reservations.utils.validator.Validator

class CreateReservationDTOValidator : BaseValidator(), Validator<CreateReservationDTO> {
    override fun validate(data: CreateReservationDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        exceptions.addAll(
            validateRequiredFields(data, fieldNames)
        )

        data.flightDate.ifNotNullAndBlank {
            exceptions.addAll(
                dateTimeValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(CreateReservationDTO::flightDate.name)
                )
            )
        }

        data.airline.ifNotNullAndBlank {
            exceptions.addAll(
                enumValidator.validate(
                    data = Pair(it, AirlineCode::class),
                    fieldNames = fieldNames.plus(CreateReservationDTO::airline.name)
                )
            )
        }

        data.origin.ifNotNullAndBlank {
            exceptions.addAll(
                enumValidator.validate(
                    data = Pair(it, AirportCode::class),
                    fieldNames = fieldNames.plus(CreateReservationDTO::origin.name)
                )
            )
        }

        data.destination.ifNotNullAndBlank {
            exceptions.addAll(
                enumValidator.validate(
                    data = Pair(it, AirportCode::class),
                    fieldNames = fieldNames.plus(CreateReservationDTO::destination.name)
                )
            )
        }

        data.passengersQuantity.ifNotNullAndBlank {
            exceptions.addAll(
                integerValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(CreateReservationDTO::passengersQuantity.name)
                )
            )
        }

        data.totalPrice.ifNotNullAndBlank {
            exceptions.addAll(
                doubleValidator.validate(
                    data = it,
                    fieldNames = fieldNames.plus(CreateReservationDTO::totalPrice.name)
                )
            )
        }

        data.customer.ifNotNull {
            setCustomerExceptions(
                data = it,
                fieldNames = fieldNames.plus(CreateReservationDTO::customer.name),
                exceptions = exceptions
            )
        }

        return exceptions
    }

    private fun validateRequiredFields(data: CreateReservationDTO, fieldNames: List<String>): List<Exception> {
        val exceptions = ArrayList<Exception>()

        if (data.flightDate.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CreateReservationDTO::flightDate.name))
            )
        }

        if (data.airline.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CreateReservationDTO::airline.name))
            )
        }

        if (data.origin.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CreateReservationDTO::origin.name))
            )
        }

        if (data.destination.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CreateReservationDTO::destination.name))
            )
        }

        if (data.passengersQuantity.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CreateReservationDTO::passengersQuantity.name))
            )
        }

        if (data.totalPrice.isNullOrBlank()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CreateReservationDTO::totalPrice.name))
            )
        }

        if (data.customer.isNull()) {
            exceptions.add(
                generateRequiredFieldException(fieldNames.plus(CreateReservationDTO::customer.name))
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
