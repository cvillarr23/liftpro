package com.cvillarreal.liftpro.datasource.mock

import com.cvillarreal.liftpro.datasource.UserDataSource
import com.cvillarreal.liftpro.exceptions.UserNotFoundException
import com.cvillarreal.liftpro.model.User
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository("mock")
class MockUserDataSource: UserDataSource {

    val users = mutableListOf(
        User(id = UUID(0,0), email = "test", password = "test")
    )

    override fun getUsers(): Collection<User> {
        return users
    }

    override fun retrieveUserById(id: UUID): User {
        return users.find { it.id == id } ?: throw UserNotFoundException("Could not find user with id $id")
    }

    override fun insertNewUser(user: User): Boolean {
        users.add(user)
        println("Added new user: $users")
        return true
    }

    override fun deleteUserByID(id: UUID): Boolean {
        return users.removeIf { it.id == id }
    }

}