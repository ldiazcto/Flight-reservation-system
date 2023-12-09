package edu.fiuba.reservations.domain.enums

enum class FlightType(
    override val type: String
) : EnumUtil {
    NATIONAL("N"),
    INTERNATIONAL("I");

    companion object : EnumCompanion<FlightType>
}
