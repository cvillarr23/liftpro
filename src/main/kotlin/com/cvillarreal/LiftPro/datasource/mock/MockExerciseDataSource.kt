package com.cvillarreal.LiftPro.datasource.mock

import com.cvillarreal.LiftPro.datasource.ExerciseDataSource
import com.cvillarreal.LiftPro.model.exercise.Exercise
import org.springframework.stereotype.Repository


@Repository
class MockExerciseDataSource: ExerciseDataSource {
    override fun retrieveAllExercises(): Collection<Exercise> {
        return listOf(
            Exercise(id = 0, name = "Bench Press")
        )
    }
}