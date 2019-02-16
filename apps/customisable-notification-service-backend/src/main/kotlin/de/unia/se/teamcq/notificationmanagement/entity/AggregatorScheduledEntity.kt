package de.unia.se.teamcq.notificationmanagement.entity

import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Entity
// Constructor with (null)-default values for everything necessary for MapStruct
class AggregatorScheduledEntity(

    aggregatorId: Long? = null,

    @get: NotNull
    var notificationCronTrigger: String? = null

) : AggregatorEntity(aggregatorId) {

    // Autogenerated
    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (notificationCronTrigger?.hashCode() ?: 0)
        return result
    }

    // Autogenerated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AggregatorScheduledEntity) return false
        if (!super.equals(other)) return false

        if (notificationCronTrigger != other.notificationCronTrigger) return false

        return true
    }
}
