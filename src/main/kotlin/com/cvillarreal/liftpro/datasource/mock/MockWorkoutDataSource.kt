package com.cvillarreal.liftpro.datasource.mock

import com.cvillarreal.liftpro.datasource.WorkoutDataSource
import com.cvillarreal.liftpro.model.Workout
import com.cvillarreal.liftpro.model.exercise.UserExerciseInstance
import com.cvillarreal.liftpro.model.exercise.ExerciseSet
import com.cvillarreal.liftpro.model.weights.BaseWeight
import com.cvillarreal.liftpro.model.weights.ExerciseWeight
import com.cvillarreal.liftpro.model.weights.Weight
import org.springframework.stereotype.Repository
import java.sql.Date
import java.util.UUID
import java.lang.System.currentTimeMillis

@Repository
class MockWorkoutDataSource: WorkoutDataSource {
    override fun retrieveAllWorkouts(): Collection<Workout> {
        return listOf(
            Workout(
                id = UUID.randomUUID(),
                name = "Leg Day",

                exercises = listOf(
                    UserExerciseInstance(
                        id = UUID.randomUUID(),
                        workoutID = UUID.randomUUID(),
                        exerciseID = 1,
                        date = Date(currentTimeMillis()),
                        instanceSets = listOf(
                            ExerciseSet(
                                id = UUID.randomUUID(),
                                weight = ExerciseWeight(
                                    totalWeight = Weight(100.0),
                                    baseWeight = BaseWeight("Olympic", Weight(20.0))),
                                reps = 10,
                                exerciseInstanceID = UUID.randomUUID()
                            )
                        ),
                        notes = "",
                        userID = UUID.randomUUID()
                    )
                ),
            )
        )
    }
}