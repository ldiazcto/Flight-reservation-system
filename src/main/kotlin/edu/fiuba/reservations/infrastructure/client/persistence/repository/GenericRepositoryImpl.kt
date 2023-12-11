package edu.fiuba.reservations.infrastructure.client.persistence.repository

import com.google.cloud.firestore.CollectionReference
import edu.fiuba.reservations.application.exception.ExceptionCode.DATABASE_INTERNAL_ERROR
import edu.fiuba.reservations.domain.entity.Error
import edu.fiuba.reservations.domain.exception.ReservationException
import edu.fiuba.reservations.utils.isNotNullAndBlank
import edu.fiuba.reservations.utils.isNull
import org.springframework.http.HttpStatus

abstract class GenericRepositoryImpl<T>(
    private val clazz: Class<T>
) : GenericRepository<T> {
    override fun get(id: String): T {
        val query = getCollection().whereEqualTo("id", id)
        val futureDocument = query.get()
        val document = futureDocument.get().documents.first()

        if (document.exists()) {
            return document.toObject(clazz)!!
        }

        throw ReservationException(
            DATABASE_INTERNAL_ERROR.getMessage(),
            DATABASE_INTERNAL_ERROR.getCode(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            listOf(
                Error(DATABASE_INTERNAL_ERROR)
            )
        )
    }

    override fun save(entity: T): T {
        val futureDocument = getCollection().add(entity)
        val document = futureDocument.get()

        if (document.id.isNotNullAndBlank()) {
            return entity
        }

        throw ReservationException(
            DATABASE_INTERNAL_ERROR.getMessage(),
            DATABASE_INTERNAL_ERROR.getCode(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            listOf(
                Error(DATABASE_INTERNAL_ERROR)
            )
        )
    }

    override fun delete(id: String) {
        val query = getCollection().whereEqualTo("id", id)
        val futureDocument = query.get()
        val document = futureDocument.get().documents.first()

        val writeResult = getCollection().document(document.id).delete()

        if (writeResult.get().updateTime.isNull()) {
            throw ReservationException(
                DATABASE_INTERNAL_ERROR.getMessage(),
                DATABASE_INTERNAL_ERROR.getCode(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                listOf(
                    Error(DATABASE_INTERNAL_ERROR)
                )
            )
        }
    }

    abstract fun getCollection(): CollectionReference
}
