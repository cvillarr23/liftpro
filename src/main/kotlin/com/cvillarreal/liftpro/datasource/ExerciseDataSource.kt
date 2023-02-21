package com.cvillarreal.liftpro.datasource

import com.cvillarreal.liftpro.model.exercise.Exercise

interface ExerciseDataSource{
    fun retrieveAllExercises(): Collection<Exercise>
}
