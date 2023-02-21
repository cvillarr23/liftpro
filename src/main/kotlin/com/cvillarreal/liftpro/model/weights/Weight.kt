package com.cvillarreal.liftpro.model.weights


/**
 * Represents a weight in kilograms.
 */
class Weight{

    val weightKg: Double

    constructor(weightKg: Double) {
        if (weightKg < 0) {
            throw IllegalArgumentException("Weight cannot be negative")
        }
        this.weightKg = weightKg
    }

    /**
     * Converts the weight to pounds
     * @return The weight in pounds
     */
    fun toPounds(): Double {
        return weightKg * 2.20462
    }

    /**
     * Convert to Lb and return a string of the weight with 1 decimal place.
     */
    fun toStringLb(): String {
        return String.format("%.1f lb", weightKg * 2.20462)
    }

    /**
     * Return a string of the weight with 1 decimal place.
     */
    fun toStringKg(): String {
        return String.format("%.1f kg", weightKg)
    }
}


