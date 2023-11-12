package edu.fiuba.reservations.domain.enums

import com.fasterxml.jackson.annotation.JsonValue

interface EnumCompanion<T : Enum<T>>

interface EnumUtil {
    val type: String
    val name: String

    @JsonValue
    fun getEnumName(): String {
        return name.lowercase()
    }
}

inline fun <reified T> EnumCompanion<T>.fromCode(value: String): T? where T : Enum<T>, T : EnumUtil {
    return enumValues<T>().firstOrNull { it.type == value.uppercase() }
}

inline fun <reified T> EnumCompanion<T>.fromValue(value: String): T? where T : Enum<T>, T : EnumUtil {
    return enumValues<T>().firstOrNull { it.name == value.uppercase() }
}
