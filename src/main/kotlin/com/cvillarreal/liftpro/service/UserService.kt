package com.cvillarreal.LiftPro.service

import com.cvillarreal.LiftPro.datasource.UserDataSource
import com.cvillarreal.liftpro.exceptions.UserNotFoundException
import com.cvillarreal.liftpro.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userDataSource: UserDataSource
) {
    fun getUsers(): Collection<User> {
        return userDataSource.getUsers()
    }

    fun createNewUser(email: String, password: String): UUID? {
        val newUser = User(id = UUID.randomUUID(), email = email, password = password)
        if(userDataSource.insertNewUser(newUser)) {
            return newUser.id
        }
        throw Exception("Could not create new user")
    }

    fun getUserByID(id: UUID): User? {
        return try {
            userDataSource.getUserById(id)
        } catch (e: UserNotFoundException) {
            null
        }
    }


    fun deleteUser(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

}