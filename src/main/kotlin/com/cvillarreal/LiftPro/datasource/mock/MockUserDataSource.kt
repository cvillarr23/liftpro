package com.cvillarreal.LiftPro.datasource.mock

import com.cvillarreal.LiftPro.datasource.UserDataSource
import com.cvillarreal.LiftPro.model.User
import org.springframework.stereotype.Repository


@Repository
class MockUserDataSource: UserDataSource {
    override fun getUsers(): Collection<User> {
        return listOf (
            User(id = 1, email = "test@test.com", password = "test")
        )
    }

}