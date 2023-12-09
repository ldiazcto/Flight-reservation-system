package edu.fiuba.reservations.delivery.dto.response

import edu.fiuba.reservations.domain.entity.Phone
import edu.fiuba.reservations.domain.enums.PhoneType

data class PhoneDTO(
    val type: PhoneType,
    val areaCode: String,
    val number: String
) {
    constructor(entity: Phone) : this(
        type = entity.type,
        areaCode = entity.areaCode,
        number = entity.number
    )
}
