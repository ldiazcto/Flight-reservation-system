package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.entity.Document
import edu.fiuba.reservations.domain.enums.DocumentType

data class DocumentDTO(
    val type: DocumentType,
    val number: String
) {
    constructor(entity: Document) : this(
        type = entity.type,
        number = entity.number
    )
}
