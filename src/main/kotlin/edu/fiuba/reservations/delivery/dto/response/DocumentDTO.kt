package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.entity.Document

data class DocumentDTO(
    val type: String?,
    val number: String?
) {
    constructor(entity: DocumentDTO) : this(
        type = entity.type,
        number = entity.number
    )

    constructor(entity: Document) : this(
        type = entity.type.name,
        number = entity.number
    )
}
