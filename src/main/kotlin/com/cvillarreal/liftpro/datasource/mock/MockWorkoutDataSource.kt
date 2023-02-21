package com.cvillarreal.liftpro.datasource.mock

import com.cvillarreal.liftpro.datasource.WorkoutDataSource
import com.cvillarreal.liftpro.model.Workout
import com.cvillarreal.liftpro.model.exercise.Exercise
import com.cvillarreal.liftpro.model.exercise.UserExerciseInstance
import com.cvillarreal.liftpro.model.exercise.ExerciseSet
import org.springframework.stereotype.Repository
import java.sql.Date

@Repository
class MockWorkoutDataSource: WorkoutDataSource {
    override fun retrieveAllWorkouts(): Collection<Workout> {
        return listOf(
            Workout(
                id = 0,
                name = "Leg Day",
                exercises = listOf<UserExerciseInstance>(
                    UserExerciseInstance(
                        id = 0,
                        workoutID = 0,
                        exerciseID = 0,
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
                    UserExerciseInstance(
                        id = 1,
                        workoutID = 0,
                        exerciseID = 1,
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