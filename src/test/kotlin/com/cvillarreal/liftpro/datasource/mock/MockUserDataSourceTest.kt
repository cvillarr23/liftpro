package com.cvillarreal.liftpro.datasource.mock

import com.cvillarreal.LiftPro.datasource.mock.MockUserDataSource
import com.cvillarreal.liftpro.exceptions.NoUserFoundException
import com.cvillarreal.liftpro.model.User
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.util.*

internal  class MockUserDataSourceTest {

    @Test
    fun `should provide a collection of users`() {
        //given


        // when
        val userDataSource = MockUserDataSource()
        userDataSource.insertNewUser(user = User(id = UUID.randomUUID(), email = "test@test.com", password = "test"))
        userDataSource.getUsers()

        // then
        assertThat(userDataSource.getUsers()).isNotEmpty
        assertThat(userDataSource.getUsers()).hasSize(1)
     }


    @Test
    fun `should create a new user and store it for retrieval`() {
        //given


        // when
        val userDataSource = MockUserDataSource()
        val newUser = User(id = UUID.randomUUID(), email = "test@test.com", password = "test")
        val res = userDataSource.insertNewUser(user = newUser)

        val retrievedUser = userDataSource.getUserById(id = newUser.id)

        // then
        assertThat(res).isTrue
        assertThat(retrievedUser.id).isNotNull
        assertThat(retrievedUser.id).isInstanceOf(UUID::class.java)
        assertThat(retrievedUser.id).isEqualTo(newUser.id)
     }

    @Test
    fun `should throw a NoUserFoundException when trying to retrieve a user that does not exist`() {
        // when
        val userDataSource = MockUserDataSource()

        // then
        assertThatThrownBy {
            userDataSource.getUserById(id = UUID.randomUUID())
        }.isInstanceOf(NoUserFoundException::class.java)
     }


}