package com.cvillarreal.liftpro.datasource

import com.cvillarreal.liftpro.model.Workout

interface  WorkoutDataSource {
        fun  retrieveAllWorkouts(): Collection<Workout>

}
