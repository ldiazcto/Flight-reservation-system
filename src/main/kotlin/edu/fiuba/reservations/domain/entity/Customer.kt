package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.delivery.dto.response.CustomerDTO

data class Customer(
    val firstName: String,
    val lastName: String,
    val documents: List<Document>,
    val email: String,
    val phone: Phone
) {
    constructor(entity: CustomerDTO) : this(
        firstName = entity.firstName!!,
        lastName = entity.lastName!!,
        documents = entity.documents!!.map { Document(it) },
        email = entity.email!!,
        phone = Phone(entity.phone!!)
    )

    constructor(entity: Customer, updatedEntity: Customer) : this(
        firstName = updatedEntity.firstName,
        lastName = updatedEntity.lastName,
        documents = updatedEntity.documents.plus(
            entity.documents.filterNot { doc -> doc.type in updatedEntity.documents.map { it.type } }
        ),
        email = updatedEntity.email,
        phone = updatedEntity.phone
    )
}
