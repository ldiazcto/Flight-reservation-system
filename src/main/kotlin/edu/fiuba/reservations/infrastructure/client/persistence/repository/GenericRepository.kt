package edu.fiuba.reservations.infrastructure.client.persistence.repository

interface GenericRepository<T> {
    fun get(id: String): T

    fun save(entity: T): T
}
