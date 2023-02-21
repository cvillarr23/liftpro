package com.cvillarreal.liftpro.model.exercise

import com.cvillarreal.liftpro.model.weights.ExerciseWeight
import java.util.UUID

/**
 * A single set of an exercise.
 * @property id the ID of the exercise in the DB.
 * @property exerciseInstanceID the matching instance that contains the set.
 * @property weight of the exercise.
 * @property reps completed in the set.
 */
data class ExerciseSet(
    val id: UUID,
    val exerciseInstanceID: UUID,
    val weight: ExerciseWeight,
    val reps: Int,
)


