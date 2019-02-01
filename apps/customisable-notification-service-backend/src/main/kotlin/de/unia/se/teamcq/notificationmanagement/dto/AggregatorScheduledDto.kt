package de.unia.se.teamcq.notificationmanagement.dto

class AggregatorScheduledDto(

    aggregatorId: Long? = 0,

    var notificationCronTrigger: String?

) : AggregatorDto(aggregatorId) {

    // Necessary for MapStruct
    constructor() : this(null, null)

    // Autogenerated
    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (notificationCronTrigger?.hashCode() ?: 0)
        return result
    }

    // Autogenerated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AggregatorScheduledDto) return false
        if (!super.equals(other)) return false

        if (notificationCronTrigger != other.notificationCronTrigger) return false

        return true
    }
}