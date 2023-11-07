package edu.fiuba.reservations.infrastructure.client.persistence

import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Firestore
import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.infrastructure.client.persistence.repository.GenericRepositoryImpl
import edu.fiuba.reservations.infrastructure.client.persistence.repository.ReservationRepository

class ReservationPersistence(
    private val firestore: Firestore
) : ReservationRepository, GenericRepositoryImpl<Reservation>(Reservation::class.java) {

    override fun getCollection(): CollectionReference {
        return firestore.collection("reservations")
    }
}
