package de.unia.se.teamcq.ruleevaluation.entity

import de.unia.se.teamcq.ruleevaluation.model.LogicalConnectiveType
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.OrderColumn
import javax.validation.constraints.NotNull

@Entity
class RuleConditionCompositeEntity(

    conditionId: Long? = 0,

    @get: NotNull
    var logicalConnective: LogicalConnectiveType?,

    @get: NotNull
    @OneToMany(fetch = FetchType.EAGER, cascade = [javax.persistence.CascadeType.ALL],
            targetEntity = RuleConditionEntity::class, orphanRemoval = true)
    @OrderColumn(name = "sub_conditions_order")
    var subConditions: List<RuleConditionEntity>

) : RuleConditionEntity(conditionId), Serializable {

    // Necessary for MapStruct
    constructor() : this(null, null, mutableListOf<RuleConditionEntity>())

    // Autogenerated
    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (logicalConnective?.hashCode() ?: 0)
        result = 31 * result + subConditions.hashCode()
        return result
    }

    // Autogenerated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as RuleConditionCompositeEntity

        if (logicalConnective != other.logicalConnective) return false
        if (subConditions != other.subConditions) return false

        return true
    }
}