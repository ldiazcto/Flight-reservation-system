package edu.fiuba.reservations.domain.enums

import com.fasterxml.jackson.annotation.JsonValue

interface EnumCompanion<T: Enum<T>>

interface EnumUtil {
    val type: String
    val name: String

    @JsonValue
    fun getEnumName(): String {
        return name.lowercase()
    }
}

inline fun <reified T> EnumCompanion<T>.fromCode(value: String)
