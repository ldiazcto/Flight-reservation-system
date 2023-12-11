package edu.fiuba.reservations.infrastructure.client.persistence.entity

data class CustomerEntity(
    val firstName: String = String(),
    val lastName: String = String(),
    val documents: List<DocumentEntity> = listOf(),
    val email: String = String(),
    val phone: PhoneEntity = PhoneEntity()
)
