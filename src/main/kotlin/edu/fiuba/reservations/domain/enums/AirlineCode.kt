package edu.fiuba.reservations.domain.enums

enum class AirlineCode(
    override val type: String
) : EnumUtil {
    AMERICAN_AIRLINES("AA"),
    SOUTHWEST_AIRLINES("WN");

    companion object : EnumCompanion<AirlineCode>
}