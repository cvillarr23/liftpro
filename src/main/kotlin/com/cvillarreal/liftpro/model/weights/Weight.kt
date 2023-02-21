package com.cvillarreal.liftpro.model.weights


/**
 * Represents a weight in kilograms.
 */
class Weight(
    val weightKg: Double,
) {

    /**
     * Converts the weight to pounds
     * @return The weight in pounds
     */
    fun toPounds(): Weight {
        return Weight(weightKg * 2.20462)
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


