package edu.fiuba.reservations.domain.enums

enum class PhoneType(
    override val type: String
) : EnumUtil {
    CELL_PHONE("001"),
    LANDLINE_PHONE("002");

    companion object : EnumCompanion<PhoneType>
}
