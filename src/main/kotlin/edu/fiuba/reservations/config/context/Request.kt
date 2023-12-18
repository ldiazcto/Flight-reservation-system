package edu.fiuba.reservations.config.context

data class Request(
    var endpoint: String,
    val headers: Map<HeaderType, String>
)
