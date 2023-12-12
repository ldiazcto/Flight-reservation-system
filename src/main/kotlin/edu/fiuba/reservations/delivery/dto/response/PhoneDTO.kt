package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.entity.Phone
import edu.fiuba.reservations.utils.ifNotNullAndBlank

data class PhoneDTO(
    val type: String?,
    val areaCode: String?,
    val number: String?
) {
    constructor(entity: PhoneDTO) : this(
        type = entity.type,
        areaCode = entity.areaCode,
        number = entity.number
    )

    constructor(entity: Phone) : this(
        type = entity.type.name,
        areaCode = entity.areaCode,
        number = entity.number
    )

    constructor(entity: Phone, updatedEntity: PhoneDTO) : this(
        type = updatedEntity.type.ifNotNullAndBlank { it } ?: entity.type.name,
        areaCode = updatedEntity.areaCode.ifNotNullAndBlank { it } ?: entity.areaCode,
        number = updatedEntity.number.ifNotNullAndBlank { it } ?: entity.number
    )
}
