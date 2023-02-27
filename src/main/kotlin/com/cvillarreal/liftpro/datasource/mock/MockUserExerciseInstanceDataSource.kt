package com.cvillarreal.liftpro.datasource.mock

import com.cvillarreal.liftpro.datasource.UserExerciseInstanceDataSource
import com.cvillarreal.liftpro.model.exercise.UserExerciseInstance
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MockUserExerciseInstanceDataSource: UserExerciseInstanceDataSource {
    override fun retrieveAllExerciseInstancesByUserAndExercise(
        userID: UUID,
        exerciseID: Int
    ): Collection<UserExerciseInstance> {
        TODO("Not yet implemented")
    }

    override fun retrieveExerciseInstanceByID(id: UUID): UserExerciseInstance? {
        TODO("Not yet implemented")
    }

    override fun retrieveExerciseInstancesByWorkoutID(workoutID: UUID): Collection<UserExerciseInstance> {
        TODO("Not yet implemented")
    }

    override fun createExerciseInstance(exerciseInstance: UserExerciseInstance): UUID {
        TODO("Not yet implemented")
    }

    override fun updateExerciseInstance(exerciseInstance: UserExerciseInstance): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteExerciseInstance(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

}