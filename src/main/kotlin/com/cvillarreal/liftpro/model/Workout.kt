package com.cvillarreal.liftpro.model

import com.cvillarreal.liftpro.model.exercise.UserExerciseInstance
import java.util.UUID

data class Workout(
    val id: UUID,
    val name: String,
    val exercises: Collection<UserExerciseInstance>
)
