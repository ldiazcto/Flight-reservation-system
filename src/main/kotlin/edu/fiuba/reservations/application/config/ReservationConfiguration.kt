package edu.fiuba.reservations.application.config

import com.google.cloud.firestore.Firestore
import edu.fiuba.reservations.delivery.controller.ReservationController
import edu.fiuba.reservations.infrastructure.client.persistence.ReservationPersistence
import edu.fiuba.reservations.infrastructure.service.ReservationService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ReservationConfiguration {
    @Bean
    fun reservationController(
        reservationService: ReservationService
    ): ReservationController {
        return ReservationController(
            reservationService
        )
    }

    @Bean
    fun reservationPersistence(
        @Value("\${data.firebase.collections.reservation.name}") collectionName: String,
        firestore: Firestore
    ): ReservationPersistence {
        return ReservationPersistence(
            collectionName,
            firestore
        )
    }
}
