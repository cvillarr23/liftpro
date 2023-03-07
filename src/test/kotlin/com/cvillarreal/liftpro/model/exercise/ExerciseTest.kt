package com.cvillarreal.liftpro.model.exercise

import com.cvillarreal.liftpro.model.weights.BaseWeight
import com.cvillarreal.liftpro.model.weights.ExerciseWeight
import com.cvillarreal.liftpro.model.weights.Weight
import com.cvillarreal.liftpro.model.weights.WeightUnit
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ExerciseTest {
    @Test
    fun `should be able to access all properties`() {
        // when
        val newExercise = Exercise(
            1,
            "Bench Press",
            BaseWeight("Barbell (20kg/45lb)", Weight(20.0, WeightUnit.KILOGRAMS)),
            "Lay on the bench and press the bar",
            BodyPart.CHEST
        )

        // then
        assertEquals(1, newExercise.id)
        assertEquals("Bench Press", newExercise.name)
        assertEquals("Barbell (20kg/45lb)", newExercise.baseWeight.name)
        assertEquals(44.092, newExercise.baseWeight.weight.weightLb, 0.001)
        assertEquals("Lay on the bench and press the bar", newExercise.description)
     }


}