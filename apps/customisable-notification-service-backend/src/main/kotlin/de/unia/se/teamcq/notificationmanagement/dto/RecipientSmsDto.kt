package de.unia.se.teamcq.notificationmanagement.dto

// Constructor with (null)-default values for everything necessary for MapStruct
class RecipientSmsDto(

    recipientId: Long? = null,

    var phoneNumber: String? = null

) : RecipientDto(recipientId) {

    // Autogenerated
    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (phoneNumber?.hashCode() ?: 0)
        return result
    }

    // Autogenerated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RecipientSmsDto) return false
        if (!super.equals(other)) return false

        if (phoneNumber != other.phoneNumber) return false

        return true
    }
}
