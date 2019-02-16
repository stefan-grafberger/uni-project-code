package de.unia.se.teamcq.notificationmanagement.entity

import javax.persistence.Entity

@Entity
// Constructor with (null)-default values for everything necessary for MapStruct
class AggregatorImmediateEntity(

    aggregatorId: Long? = null

) : AggregatorEntity(aggregatorId) {

    // Autogenerated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AggregatorImmediateEntity) return false
        if (!super.equals(other)) return false
        return true
    }
}
