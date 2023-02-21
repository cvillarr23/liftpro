package com.cvillarreal.liftpro.model.weights

/**
 * Represents a weight in kilograms
 * @property weight The weight in kilograms
 * @constructor Creates a new weight
 */
class ExerciseWeight(
    val weight: Double,
    val baseWeight: BaseWeight? = null
) {

    /**
     * Converts the weight to pounds
     * @return The weight in pounds
     */
    fun toPounds(): ExerciseWeight {
        return ExerciseWeight(weight * 2.20462)
    }

    /**
     * Calculates the number of plates needed to reach the desired weight.
     * @return A list of plates needed to reach the desired weight on each side.
     */
    fun calculatePlates(): List<Weight>{
        TODO("Not yet implemented")
    }


}