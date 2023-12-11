package edu.fiuba.reservations.domain.entity

import edu.fiuba.reservations.delivery.dto.response.PhoneDTO
import edu.fiuba.reservations.domain.enums.PhoneType
import edu.fiuba.reservations.domain.enums.fromValue

data class Phone(
    val type: PhoneType,
    val areaCode: String,
    val number: String
) {
    constructor(entity: PhoneDTO) : this(
        type = PhoneType.fromValue(entity.type!!)!!,
        areaCode = entity.areaCode!!,
        number = entity.number!!
    )
}
