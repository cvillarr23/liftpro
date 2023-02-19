package com.cvillarreal.LiftPro.datasource

import com.cvillarreal.LiftPro.model.Workout

interface  WorkoutDataSource {
        fun  retrieveAllWorkouts(): Collection<Workout>

}
