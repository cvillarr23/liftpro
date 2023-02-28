package com.cvillarreal.liftpro.model.weights

enum class PlatesLb(val weight: Weight) {
    FORTY_FIVE(Weight(45.0, WeightUnit.POUNDS)),
    THIRTY_FIVE(Weight(35.0, WeightUnit.POUNDS)),
    TWENTY_FIVE(Weight(25.0, WeightUnit.POUNDS)),
    TEN(Weight(10.0, WeightUnit.POUNDS)),
    FIVE(Weight(5.0, WeightUnit.POUNDS)),
    TWO_POINT_FIVE(Weight(2.5, WeightUnit.POUNDS)),
    ONE_POINT_TWO_FIVE(Weight(1.25, WeightUnit.POUNDS))
}

enum class PlatesKg(val weight: Weight) {
    TWENTY_FIVE(Weight(25.0, WeightUnit.KILOGRAMS)),
    TWENTY(Weight(20.0, WeightUnit.KILOGRAMS)),
    FIFTEEN(Weight(15.0, WeightUnit.KILOGRAMS)),
    TEN(Weight(10.0, WeightUnit.KILOGRAMS)),
    FIVE(Weight(5.0, WeightUnit.KILOGRAMS)),
    TWO_POINT_FIVE(Weight(2.5, WeightUnit.KILOGRAMS)),
    ONE(Weight(1.0, WeightUnit.KILOGRAMS)),
    ZERO_POINT_FIVE(Weight(0.5, WeightUnit.KILOGRAMS)),
    ZERO_POINT_TWO_FIVE(Weight(0.25, WeightUnit.KILOGRAMS))
}


/**
 * Represents a weight in kilograms
 * @property totalWeight The weight in kilograms
 * @constructor Creates a new weight
 */
class ExerciseWeight{

    var totalWeight: Weight
    var baseWeight: BaseWeight? = null

    constructor(totalWeight: Weight, baseWeight: BaseWeight? = null) {
        if (totalWeight.weightLb < 0) {
            throw IllegalArgumentException("Weight cannot be negative")
        }
        if (baseWeight != null && baseWeight.weight.weightLb > totalWeight.weightLb) {
            throw IllegalArgumentException("Base weight cannot be greater than total weight")
        }

        this.totalWeight = totalWeight
        this.baseWeight = baseWeight
    }

    /**
     * Converts the weight to kilograms
     * @return The weight in kilograms
     */
    fun toKilogram(): Double {
        return totalWeight.toKilogram()
    }

    /**
     * Calculates the number of plates needed to reach the desired weight.
     * @return A list of plates needed to reach the desired weight on each side.
     */
    fun calculatePlates(unit: WeightUnit = WeightUnit.POUNDS): List<Weight>{
        return if (unit == WeightUnit.KILOGRAMS) {
            calculatePlatesKg()
        } else {
            // Calculate the number of plates needed for each side, minus the base weight
            calculatePlatesLb()
        }
    }

    private fun calculatePlatesKg(): List<Weight> {
        val plates = mutableListOf<Weight>()
        var remainingWeight = (totalWeight.toKilogram() - baseWeight!!.weight.toKilogram()) / 2.0
        var plateIndex = 0
        val minIncrement = PlatesKg.values().last().weight.toKilogram()
        println("Remaining weight: $remainingWeight, min increment: $minIncrement")
        while (remainingWeight > minIncrement) {
            val plate = PlatesKg.values()[plateIndex]
            if (remainingWeight >= plate.weight.toKilogram()) {
                plates.add(plate.weight)
                remainingWeight -= plate.weight.toKilogram()
                println("Added plate: ${plate.weight.toStringKg()}, remaining weight: $remainingWeight")
            } else {
                plateIndex++
            }
        }
        println()
        return plates
    }

    private fun calculatePlatesLb(): List<Weight> {
        val plates = mutableListOf<Weight>()
        var remainingWeight = (totalWeight.weightLb - baseWeight!!.weight.weightLb) / 2.0
        var plateIndex = 0
        val minIncrement = PlatesLb.values().last().weight.weightLb
        while (remainingWeight > minIncrement) {
            val plate = PlatesLb.values()[plateIndex]
            if (remainingWeight >= plate.weight.weightLb) {
                plates.add(plate.weight)
                remainingWeight -= plate.weight.weightLb
            } else {
                plateIndex++
            }
        }
        return plates
    }

}