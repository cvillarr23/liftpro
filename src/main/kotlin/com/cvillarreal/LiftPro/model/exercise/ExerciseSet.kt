package com.cvillarreal.LiftPro.model.exercise

data class ExerciseSet(
    val id: Int = 0,
    val exerciseInstanceId: Int,
    val weight: Double,
    val reps: Int,
    val notes: String,
    val user: Int,
)


