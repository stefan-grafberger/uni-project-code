package de.unia.se.teamcq.ruleevaluation.dto

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "@type")
@JsonSubTypes(
        JsonSubTypes.Type(value = RuleConditionCompositeDto::class),
        JsonSubTypes.Type(value = RuleConditionPredicateDto::class)
)
abstract class RuleConditionDto(

    var conditionId: Long? = 0

) {

    // Autogenerated by IntelliJ
    override fun hashCode(): Int {
        return conditionId?.hashCode() ?: 0
    }

    // Autogenerated by IntelliJ
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RuleConditionDto) return false

        if (conditionId != other.conditionId) return false

        return true
    }
}
