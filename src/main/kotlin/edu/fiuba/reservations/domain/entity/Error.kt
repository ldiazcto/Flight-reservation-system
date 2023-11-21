package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.utils.enums.Exception

data class Error(
    val code: String,
    val message: String
) {
    constructor(entity: Exception) : this(
        entity.getCode(),
        entity.getMessage()
    )
}
