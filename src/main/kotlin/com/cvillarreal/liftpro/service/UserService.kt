package com.cvillarreal.liftpro.service

import com.cvillarreal.liftpro.datasource.UserDataSource
import com.cvillarreal.liftpro.exceptions.UserNotFoundException
import com.cvillarreal.liftpro.model.User
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    @Qualifier("mock")
    private val userDataSource: UserDataSource
) {
    fun getUsers(): Collection<User> {
        return userDataSource.getUsers()
    }

    fun createNewUser(email: String, password: String): UUID? {
        val id = UUID.randomUUID()
        println("Generated new user id: $id")
        val newUser = User(id = id, email = email, password = password)
        println("Creating new user: $newUser")
        if(userDataSource.insertNewUser(newUser)) {
            return id
        }
        throw Exception("Could not create new user")
    }

    fun getUserByID(id: UUID): User? {
        return try {
            userDataSource.retrieveUserById(id)
        } catch (e: UserNotFoundException) {
            null
        }
    }


    fun deleteUser(id: UUID): Boolean {
        return userDataSource.deleteUserByID(id)
    }

}