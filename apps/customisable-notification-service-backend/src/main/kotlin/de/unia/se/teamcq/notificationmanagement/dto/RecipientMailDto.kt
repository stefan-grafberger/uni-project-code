package de.unia.se.teamcq.notificationmanagement.dto

// Constructor with (null)-default values for everything necessary for MapStruct
class RecipientMailDto(

    recipientId: Long? = null,

    var mailAddress: String? = null

) : RecipientDto(recipientId) {

    // Autogenerated
    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (mailAddress?.hashCode() ?: 0)
        return result
    }

    // Autogenerated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RecipientMailDto) return false
        if (!super.equals(other)) return false

        if (mailAddress != other.mailAddress) return false

        return true
    }
}
