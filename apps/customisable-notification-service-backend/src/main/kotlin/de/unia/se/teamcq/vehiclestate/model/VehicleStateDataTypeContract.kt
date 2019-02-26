package de.unia.se.teamcq.vehiclestate.model

import de.unia.se.teamcq.ruleevaluation.model.EvaluationStrategies
import de.unia.se.teamcq.ruleevaluation.model.FieldDataType
import de.unia.se.teamcq.ruleevaluation.model.PredicateField
import org.springframework.stereotype.Component
import java.sql.Date
import java.time.Instant
import java.time.ZoneOffset

@Component
// Constructor with (null)-default values for everything necessary for MapStruct
class VehicleStateDataTypeContract(

    var endMileage: Int? = null,

    var endDate: Date? = null,

    var reachedRuntimePercentage: Int? = null,

    var remainingDays: Int? = null,

    var startDate: Date? = null,

    var startMileage: Int? = null,

    dataTypeId: Long? = null

) : VehicleStateDataType(dataTypeId) {

    override val predicateFieldProviderName: String = PREDICATE_FIELD_PROVIDER_NAME

    override val predicateFields: Map<String, PredicateField> = PREDICATE_FIELDS

    @Throws(IllegalArgumentException::class)
    override fun retrieveFieldValue(fieldName: String): Any? {
        return when (fieldName) {
            "endMileage" -> this.endMileage
            "endDate" -> convertDateToInstant(this.endDate)
            "reachedRuntimePercentage" -> this.reachedRuntimePercentage
            "remainingDays" -> this.remainingDays
            "startDate" -> convertDateToInstant(this.startDate)
            "startMileage" -> this.startMileage
            else -> super.retrieveFieldValue(fieldName)
        }
    }

    // Autogenerated
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is VehicleStateDataTypeContract) return false
        if (!super.equals(other)) return false

        if (endMileage != other.endMileage) return false
        if (endDate != other.endDate) return false
        if (reachedRuntimePercentage != other.reachedRuntimePercentage) return false
        if (remainingDays != other.remainingDays) return false
        if (startDate != other.startDate) return false
        if (startMileage != other.startMileage) return false
        if (predicateFieldProviderName != other.predicateFieldProviderName) return false
        if (predicateFields != other.predicateFields) return false

        return true
    }

    // Autogenerated
    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (endMileage ?: 0)
        result = 31 * result + (endDate?.hashCode() ?: 0)
        result = 31 * result + (reachedRuntimePercentage ?: 0)
        result = 31 * result + (remainingDays ?: 0)
        result = 31 * result + (startDate?.hashCode() ?: 0)
        result = 31 * result + (startMileage ?: 0)
        result = 31 * result + predicateFieldProviderName.hashCode()
        result = 31 * result + predicateFields.hashCode()
        return result
    }

    companion object {
        const val PREDICATE_FIELD_PROVIDER_NAME = "Contract"
        val PREDICATE_FIELDS = mapOf(
            "endMileage" to PredicateField("endMileage", FieldDataType.KILOMETER, EvaluationStrategies.NUMERIC),
            "endDate" to PredicateField("endDate", FieldDataType.DATE, EvaluationStrategies.NUMERIC),
            "reachedRuntimePercentage" to PredicateField("reachedRuntimePercentage", FieldDataType.PERCENTAGE_INT, EvaluationStrategies.NUMERIC),
            "remainingDays" to PredicateField("remainingDays", FieldDataType.DAY, EvaluationStrategies.NUMERIC),
            "startDate" to PredicateField("startDate", FieldDataType.DATE, EvaluationStrategies.NUMERIC),
            "startMileage" to PredicateField("startMileage", FieldDataType.KILOMETER, EvaluationStrategies.NUMERIC)
        )

        fun convertDateToInstant(date: Date?): Instant? {
            return date?.toLocalDate()?.atStartOfDay(ZoneOffset.UTC)?.toInstant()
        }
    }
}
