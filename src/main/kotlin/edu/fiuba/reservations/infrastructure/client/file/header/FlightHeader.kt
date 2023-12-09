package edu.fiuba.reservations.infrastructure.client.file.header

enum class FlightHeader(
    val label: String
) {
    FLIGHT_ID("flight_id"),
    AIRLINE("airline"),
    FLIGHT_TYPE("flight_type"),
    PLANNED_DEPARTURE("planned_departure"),
    REAL_DEPARTURE("real_departure"),
    PLANNED_ARRIVAL("planned_arrival"),
    REAL_ARRIVAL("real_arrival"),
    ORIGIN_AIRPORT("origin_airport"),
    ORIGIN_CITY("origin_city"),
    ORIGIN_STATE("origin_state"),
    ORIGIN_COUNTRY("origin_country"),
    DESTINATION_AIRPORT("destination_airport"),
    DESTINATION_CITY("destination_city"),
    DESTINATION_STATE("destination_state"),
    DESTINATION_COUNTRY("destination_country"),
    PRICE("price");
}
