package com.cvillarreal.LiftPro.datasource.mock

import com.cvillarreal.LiftPro.datasource.UserDataSource
import com.cvillarreal.liftpro.exceptions.NoUserFoundException
import com.cvillarreal.liftpro.model.User
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class MockUserDataSource: UserDataSource {

    val users = mutableListOf<User>()

    override fun getUsers(): Collection<User> {
        return listOf (
            User(id = UUID.randomUUID(), email = "test@test.com", password = "test")
        )
    }

    override fun getUserById(id: UUID): User {
        return users.find { it.id == id } ?: throw NoUserFoundException("Could not find user with id $id")
    }

    override fun insertNewUser(user: User): Boolean {
        users.add(user)
        return true
    }

}