package com.cvillarreal.liftpro.model.exercise

import java.sql.Date
import java.util.UUID

/**
 * Represents an instance of an exercise performed by a user.
 * @property id identifying the instance in the DB
 * @property userID that performed the instance.
 * @property workoutID representing the exercise that was performed
 * @property date of the instance, excluding time
 * @property instanceSets a list of the sets in the instance
 * @property notes the user created on this instance
 */
data class UserExerciseInstance(
    val id: UUID,
    val userID: UUID,
    val workoutID: UUID,
    val exerciseID: Int,
    val date: Date,
    val exercise: Exercise,
    val instanceSets: List<ExerciseSet>,
    val notes: String,
    )
