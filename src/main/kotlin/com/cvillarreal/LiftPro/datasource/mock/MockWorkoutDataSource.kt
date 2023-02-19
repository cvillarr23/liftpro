package com.cvillarreal.LiftPro.datasource.mock

import com.cvillarreal.LiftPro.datasource.WorkoutDataSource
import com.cvillarreal.LiftPro.model.Workout
import com.cvillarreal.LiftPro.model.exercise.Exercise
import com.cvillarreal.LiftPro.model.exercise.ExerciseInstance
import com.cvillarreal.LiftPro.model.exercise.ExerciseSet
import org.springframework.stereotype.Repository
import java.sql.Date

@Repository
class MockWorkoutDataSource: WorkoutDataSource {
    override fun retrieveAllWorkouts(): Collection<Workout> {
        return listOf(
            Workout(
                id = 0,
                name = "Leg Day",
                exercises = listOf<ExerciseInstance>(
                    ExerciseInstance(
                        id = 0,
                        workoutId = 0,
                        exerciseId = 0,
                        date = Date(0),
                        exercise = Exercise(
                            id = 0,
                            name = "Squat"
                        ),
                        instanceSets = listOf<ExerciseSet>(
                            ExerciseSet(
                                id = 0,
                                exerciseInstanceId = 0,
                                weight = 0.0,
                                reps = 0,
                                notes = "",
                                user = 0
                            )
                        ),
                        notes = "",
                        user = 0
                    ),
                    ExerciseInstance(
                        id = 1,
                        workoutId = 0,
                        exerciseId = 1,
                        date = Date(0),
                        exercise = Exercise(
                            id = 1,
                            name = "Deadlift"
                        ),
                        instanceSets = listOf<ExerciseSet>(
                            ExerciseSet(
                                id = 1,
                                exerciseInstanceId = 1,
                                weight = 0.0,
                                reps = 1,
                                notes = "",
                                user = 0
                            )
                        ),
                        notes = "",
                        user = 0
                    )
                )
            )
        )
    }
}