package com.cvillarreal.liftpro.model.exercise

/**
 * Represents an instance of an exercise performed by a user.
 * @property id identifying the instance in the DB
 * @property userID that performed the instance. Retained for filtering
 * @property workoutID representing the exercise that was performed
 * @property date of the instance, excluding time
 * @property time of the instance, excluding date
 * @property instanceSets a list of the sets in the instance
 * @property notes the user created on this instance
 */
//data class UserExerciseInstance(
//    val id: UUID,
//    val userID: UUID,
//    val workoutID: UUID,
//    val exerciseID: Int,
//    val date: Date,
//    val instanceSets: List<ExerciseSet>,
//    val notes: String,
//    )
