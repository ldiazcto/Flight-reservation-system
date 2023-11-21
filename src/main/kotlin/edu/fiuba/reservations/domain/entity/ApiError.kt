package edu.fiuba.reservations.domain.entity

data class ApiError(
    var code: String,
    var message: String,
    val errors: List<Error>
)
