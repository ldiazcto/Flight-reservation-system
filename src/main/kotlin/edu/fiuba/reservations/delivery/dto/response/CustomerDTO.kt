package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.entity.Customer
import edu.fiuba.reservations.domain.enums.DocumentType
import edu.fiuba.reservations.domain.enums.fromValue
import edu.fiuba.reservations.utils.ifNotNull
import edu.fiuba.reservations.utils.ifNotNullAndBlank

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

    constructor(entity: Customer, updatedEntity: CustomerDTO) : this(
        firstName = updatedEntity.firstName.ifNotNullAndBlank { it } ?: entity.firstName,
        lastName = updatedEntity.lastName.ifNotNullAndBlank { it } ?: entity.lastName,
        documents = if (updatedEntity.documents.isNullOrEmpty()) {
            entity.documents.map { DocumentDTO(it) }
        } else {
            updatedEntity.documents.filter { doc -> DocumentType.fromValue(doc.type!!) in entity.documents.map { it.type } }
        },
        email = updatedEntity.email.ifNotNullAndBlank { it } ?: entity.email,
        phone = updatedEntity.ifNotNull { PhoneDTO(entity.phone, updatedEntity.phone!!) } ?: PhoneDTO(entity.phone)
    )
}
