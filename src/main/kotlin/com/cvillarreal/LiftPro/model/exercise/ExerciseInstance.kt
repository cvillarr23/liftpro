package com.cvillarreal.LiftPro.model.exercise

import java.sql.Date

data class ExerciseInstance(
    val id: Int = 0,
    val workoutId: Int,
    val exerciseId: Int
    val date: Date,
    val exercise: Exercise,
    val instanceSets: List<ExerciseSet>,
    val notes: String,
    val user: Int,


)
