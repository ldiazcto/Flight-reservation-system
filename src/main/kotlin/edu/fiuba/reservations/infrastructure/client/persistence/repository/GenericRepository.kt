package edu.fiuba.reservations.infrastructure.client.persistence.repository

interface GenericRepository<T> {
    fun get(entityId: String): T

    fun save(entity: T): T

    fun delete(documentId: String)
}
