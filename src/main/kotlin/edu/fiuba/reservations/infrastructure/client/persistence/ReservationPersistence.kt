package edu.fiuba.reservations.infrastructure.client.persistence

import com.google.cloud.firestore.CollectionReference
import com.google.cloud.firestore.Firestore
import edu.fiuba.reservations.domain.entity.Reservation
import edu.fiuba.reservations.infrastructure.client.persistence.entity.ReservationEntity
import edu.fiuba.reservations.infrastructure.client.persistence.mapper.ReservationEntityMapper
import edu.fiuba.reservations.infrastructure.client.persistence.repository.GenericRepositoryImpl
import edu.fiuba.reservations.infrastructure.client.persistence.repository.ReservationRepository

class ReservationPersistence(
    private val firestore: Firestore
) : ReservationRepository, GenericRepositoryImpl<ReservationEntity>(ReservationEntity::class.java) {

    fun getReservation(id: String): Reservation {
        return ReservationEntityMapper.toReservationDomain(
            get(id)
        )
    }

    override fun getCollection(): CollectionReference {
        return firestore.collection("reservations")
    }
}
