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
}
