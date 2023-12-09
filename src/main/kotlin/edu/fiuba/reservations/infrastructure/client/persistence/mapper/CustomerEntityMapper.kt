package edu.fiuba.reservations.infrastructure.client.persistence.mapper

import edu.fiuba.reservations.domain.entity.Customer
import edu.fiuba.reservations.infrastructure.client.persistence.entity.CustomerEntity

object CustomerEntityMapper {
    fun toCustomerDomain(entity: CustomerEntity): Customer {
        return Customer(
            firstName = entity.firstName.uppercase(),
            lastName = entity.lastName.uppercase(),
            documents = entity.documents.map { DocumentEntityMapper.toDocumentDomain(it) },
            email = entity.email.uppercase(),
            phone = PhoneEntityMapper.toPhoneDomain(entity.phone)
        )
    }

    fun toCustomerEntity(domain: Customer): CustomerEntity {
        return CustomerEntity(
            firstName = domain.firstName.uppercase(),
            lastName = domain.lastName.uppercase(),
            documents = domain.documents.map { DocumentEntityMapper.toDocumentEntity(it) },
            email = domain.email.uppercase(),
            phone = PhoneEntityMapper.toPhoneEntity(domain.phone)
        )
    }
}
