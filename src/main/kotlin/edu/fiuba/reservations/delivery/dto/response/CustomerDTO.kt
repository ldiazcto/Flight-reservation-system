package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.entity.Customer

data class CustomerDTO(
    val firstName: String?,
    val lastName: String?,
    val documents: List<DocumentDTO>?,
    val email: String?,
    val phone: PhoneDTO?
) {
    constructor(entity: CustomerDTO) : this(
        firstName = entity.firstName,
        lastName = entity.lastName,
        documents = entity.documents?.map { DocumentDTO(it) },
        email = entity.email,
        phone = entity.phone?.let { PhoneDTO(it) }
    )

    constructor(entity: Customer) : this(
        firstName = entity.firstName,
        lastName = entity.lastName,
        documents = entity.documents.map { DocumentDTO(it) },
        email = entity.email,
        phone = PhoneDTO(entity.phone)
    )
}
