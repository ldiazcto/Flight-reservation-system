package edu.fiuba.reservations.infrastructure.client.persistence.entity

data class PhoneEntity(
    val type: String = String(),
    val areaCode: String = String(),
    val number: String = String()
)
