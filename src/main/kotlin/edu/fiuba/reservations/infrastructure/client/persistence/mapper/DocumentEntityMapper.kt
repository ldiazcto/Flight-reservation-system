package edu.fiuba.reservations.infrastructure.client.persistence.mapper

import edu.fiuba.reservations.domain.entity.Document
import edu.fiuba.reservations.domain.enums.DocumentType
import edu.fiuba.reservations.domain.enums.fromCode
import edu.fiuba.reservations.infrastructure.client.persistence.entity.DocumentEntity

object DocumentEntityMapper {
    fun toDocumentDomain(entity: DocumentEntity): Document {
        return Document(
            type = DocumentType.fromCode(entity.type)!!,
            number = entity.number
        )
    }

    fun toDocumentEntity(domain: Document): DocumentEntity {
        return DocumentEntity(
            type = domain.type.type,
            number = domain.number
        )
    }
}
