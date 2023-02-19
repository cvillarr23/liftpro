package com.cvillarreal.LiftPro.datasource

import com.cvillarreal.LiftPro.model.exercise.Exercise

interface ExerciseDataSource{
    fun retrieveAllExercises(): Collection<Exercise>
}
