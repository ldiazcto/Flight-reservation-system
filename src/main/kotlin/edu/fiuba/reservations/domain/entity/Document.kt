package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.delivery.dto.response.DocumentDTO
import edu.fiuba.reservations.domain.enums.DocumentType

data class Document(
    val type: DocumentType,
    val number: String
) {
    constructor(entity: DocumentDTO) : this(
        type = entity.type,
        number = entity.number
    )
}
