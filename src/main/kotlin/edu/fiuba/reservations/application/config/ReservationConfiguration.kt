package edu.fiuba.reservations.application.config

import com.google.cloud.firestore.Firestore
import edu.fiuba.reservations.delivery.controller.ReservationController
import edu.fiuba.reservations.infrastructure.client.persistence.ReservationPersistence
import edu.fiuba.reservations.infrastructure.service.ReservationService
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
        firestore: Firestore
    ): ReservationPersistence {
        return ReservationPersistence(
            firestore
        )
    }
}
