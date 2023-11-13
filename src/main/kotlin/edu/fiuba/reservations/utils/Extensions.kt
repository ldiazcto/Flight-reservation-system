package edu.fiuba.reservations.utils

inline fun <T : Any, R> T?.ifNotNull(callback: (T) -> R): R? {
    return this?.let(callback)
}

inline fun <T, R> T?.ifNotNullAndBlank(callback: (T) -> R): R? where T : String? {
    return if (isNotNullAndBlank()) this?.let(callback) else null
}

fun String?.isNotNullAndBlank(): Boolean {
    return this.isNullOrBlank().not()
}
