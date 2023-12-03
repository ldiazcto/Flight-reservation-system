package edu.fiuba.reservations.config.context

enum class HeaderType(
    val label: String
) {
    REQUEST_ID("X-FIU-CorrelationId");
}
