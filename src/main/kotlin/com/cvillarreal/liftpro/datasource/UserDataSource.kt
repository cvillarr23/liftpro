package com.cvillarreal.LiftPro.datasource

import com.cvillarreal.liftpro.model.User
import java.util.*

interface UserDataSource {
    fun getUsers(): Collection<User>

    fun getUserById(id: UUID): User

    fun insertNewUser(user: User): Boolean

    fun retrieveUserByID(id: UUID): User?

}