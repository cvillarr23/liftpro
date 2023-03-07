package com.cvillarreal.liftpro.model.exercise

import com.cvillarreal.liftpro.model.weights.BaseWeight
import com.cvillarreal.liftpro.model.weights.ExerciseWeight

enum class BodyPart(val value: String) {
    CHEST("Chest"),
    BACK("Back"),
    LEGS("Legs"),
    SHOULDERS("Shoulders"),
    ARMS("Arms"),
    CORE("Core"),
    CARDIO("Cardio"),
    FULL_BODY("Full Body"),
    OTHER("Other")
}

/**
 * Represents an Exercise
 * @property id identifying the exercise in the DB
 * @property name of the exercise
 */
data class Exercise(
    val id: Int,
    val name: String,
    val baseWeight: BaseWeight,
    var description: String? = null,
    val bodyPart: BodyPart
)
