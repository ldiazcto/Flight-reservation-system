package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.entity.Phone

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
}
