package edu.fiuba.reservations.infrastructure.client.persistence.mapper

import edu.fiuba.reservations.domain.entity.Phone
import edu.fiuba.reservations.domain.enums.PhoneType
import edu.fiuba.reservations.domain.enums.fromCode
import edu.fiuba.reservations.infrastructure.client.persistence.entity.PhoneEntity

object PhoneEntityMapper {
    fun toPhoneDomain(entity: PhoneEntity): Phone {
        return Phone(
            type = PhoneType.fromCode(entity.type)!!,
            areaCode = entity.areaCode,
            number = entity.number
        )
    }

    fun toPhoneEntity(domain: Phone): PhoneEntity {
        return PhoneEntity(
            type = domain.type.type,
            areaCode = domain.areaCode,
            number = domain.number
        )
    }
}
