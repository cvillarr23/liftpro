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
    override fun retrieveAllWorkoutsByUser(userID: UUID): Collection<Workout> {
        TODO("Not yet implemented")
    }

    override fun retrieveWorkoutById(id: String): Workout? {
        TODO("Not yet implemented")
    }

    override fun retrieveMostRecentWorkoutByUser(userID: UUID): Workout? {
        TODO("Not yet implemented")
    }

    override fun createWorkout(workout: Workout): UUID {
        TODO("Not yet implemented")
    }
}