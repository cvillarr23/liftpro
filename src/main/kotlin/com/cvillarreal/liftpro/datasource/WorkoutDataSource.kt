package com.cvillarreal.liftpro.datasource

import com.cvillarreal.liftpro.model.Workout
import java.util.UUID

interface  WorkoutDataSource {
        /**
         * Retrieves all workouts for a user
         */
        fun  retrieveAllWorkoutsByUser(userID: UUID): Collection<Workout>

        /**
         * Retrieves a workout by its id.
         * @param id The id of the workout to retrieve.
         */
        fun retrieveWorkoutById(id: String): Workout?

        /**
         * Retrieves the most recent workout for a user.
         * @param userID The user to retrieve the most recent workout for.
         */
        fun retrieveMostRecentWorkoutByUser(userID: UUID): Workout?

        /**
         * Creates a new workout in the DB.
         * @param workout The workout to create.
         * @return The id of the workout created.
         */
        fun createWorkout(workout: Workout): UUID
}
