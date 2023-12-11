package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.delivery.dto.response.DocumentDTO
import edu.fiuba.reservations.domain.enums.DocumentType
import edu.fiuba.reservations.domain.enums.fromValue

data class Document(
    val type: DocumentType,
    val number: String
) {
    constructor(entity: DocumentDTO) : this(
        type = DocumentType.fromValue(entity.type!!)!!,
        number = entity.number!!
    )
}
