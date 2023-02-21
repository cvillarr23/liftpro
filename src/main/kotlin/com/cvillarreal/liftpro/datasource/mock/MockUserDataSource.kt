package com.cvillarreal.liftpro.datasource.mock

import com.cvillarreal.liftpro.datasource.UserDataSource
import com.cvillarreal.liftpro.model.User
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class MockUserDataSource: UserDataSource {
    override fun getUsers(): Collection<User> {
        return listOf (
            User(id = UUID.randomUUID(), email = "test@test.com", password = "test")
        )
    }

}