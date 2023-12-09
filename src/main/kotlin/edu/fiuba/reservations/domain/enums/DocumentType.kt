package edu.fiuba.reservations.domain.enums

enum class DocumentType(
    override val type: String
) : EnumUtil {
    CIVIC_BOOK("C"),
    CDI("D"),
    ENROLLMENT_BOOK("E"),
    IDENTITY_CARD("I"),
    CUIL("L"),
    MILITARY_CARD("M"),
    DNI("N"),
    PASSPORT("P"),
    DOCUMENT_AUTOS("S"),
    CUIT("T"),
    DOCUMENT_COURTS("U"),
    NATIONAL_VALUE_COMMISSION("V"),
    FOREIGN_ACCOUNTS_DOCUMENT("W"),
    FOREIGN_DOCUMENT("X");

    companion object : EnumCompanion<DocumentType>
}
