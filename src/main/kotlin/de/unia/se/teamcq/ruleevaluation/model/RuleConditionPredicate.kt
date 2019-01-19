package de.unia.se.teamcq.ruleevaluation.model

class RuleConditionPredicate(

    conditionId: Long? = 0,

    var providerName: String?,

    var fieldName: String?,

    var comparisonType: ComparisonType?,

    var comparisonValue: String?

) : RuleCondition(conditionId) {

    // Necessary for MapStruct
    constructor() : this(null, null, null, null, null)

    // Autogenerated by IntelliJ
    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (providerName?.hashCode() ?: 0)
        result = 31 * result + (fieldName?.hashCode() ?: 0)
        result = 31 * result + (comparisonType?.hashCode() ?: 0)
        result = 31 * result + (comparisonValue?.hashCode() ?: 0)
        return result
    }

    // Autogenerated by IntelliJ
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as RuleConditionPredicate

        if (providerName != other.providerName) return false
        if (fieldName != other.fieldName) return false
        if (comparisonType != other.comparisonType) return false
        if (comparisonValue != other.comparisonValue) return false

        return true
    }
}
