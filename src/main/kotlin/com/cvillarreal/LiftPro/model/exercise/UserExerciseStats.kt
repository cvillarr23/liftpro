package com.cvillarreal.LiftPro.model.exercise

data class UserExerciseStats(
    val id: String,
    val user_id: String,
    val instances: Collection<ExerciseInstance>
)
