package com.cvillarreal.liftpro.model.weights

enum class WeightUnit() {
    KILOGRAMS, POUNDS
}

/**
 * Represents a weight in kilograms.
 */
class Weight{

    val weightLb: Double

    constructor(weight: Double, unit: WeightUnit = WeightUnit.POUNDS) {
        if (weight < 0) {
            throw IllegalArgumentException("Weight cannot be negative")
        }
        weightLb = if(unit == WeightUnit.KILOGRAMS) {
            weight * 2.20462
        } else {
            weight
        }
    }

    /**
     * Converts the weight to kilograms
     * @return The weight in kilograms
     */
    fun toKilogram(): Double {
        return weightLb / 2.20462
    }

    /**
     * Convert to Lb and return a string of the weight with 1 decimal place.
     */
    fun toStringLb(): String {
        return String.format("%.1f lb", weightLb)
    }

    /**
     * Return a string of the weight with 1 decimal place.
     */
    fun toStringKg(): String {
        return String.format("%.1f kg", this.toKilogram())
    }

    override fun toString(): String {
        return this.toStringLb()
    }
}


