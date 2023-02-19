package com.cvillarreal.LiftPro.model

import com.cvillarreal.LiftPro.model.exercise.ExerciseInstance

data class Workout(
    val id: Int,
    val name: String,
    val exercises: Collection<ExerciseInstance>
)
