package edu.fiuba.reservations.infrastructure.client.persistence.repository

import com.google.cloud.firestore.CollectionReference
import org.apache.commons.beanutils.PropertyUtils

abstract class GenericRepositoryImpl<T>(
    private val clazz: Class<T>
) : GenericRepository<T> {
    override fun get(id: String): T {
        val reference = getCollection().document(id)
        val futureDocument = reference.get()
        val document = futureDocument.get()

        if (document.exists()) {
            val `object` = document.toObject(clazz)!!
            PropertyUtils.setProperty(`object`, "id", document.id)
            return `object`
        }

        throw Exception()
    }

    abstract fun getCollection(): CollectionReference
}
