package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.delivery.dto.response.PhoneDTO
import edu.fiuba.reservations.domain.enums.PhoneType

data class Phone(
    val type: PhoneType,
    val areaCode: String,
    val number: String
) {
    constructor(entity: PhoneDTO) : this(
        type = entity.type,
        areaCode = entity.areaCode,
        number = entity.number
    )
}
