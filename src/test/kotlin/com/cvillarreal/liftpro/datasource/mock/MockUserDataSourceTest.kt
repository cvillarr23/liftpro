package com.cvillarreal.liftpro.datasource.mock

import com.cvillarreal.liftpro.exceptions.UserNotFoundException
import com.cvillarreal.liftpro.model.User
import org.assertj.core.api.Assertions.*
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
        assertThat(userDataSource.getUsers()).hasSize(2)
     }


    @Test
    fun `should create a new user and store it for retrieval`() {
        //given


        // when
        val userDataSource = MockUserDataSource()
        val newUser = User(id = UUID.randomUUID(), email = "test@test.com", password = "test")
        val res = userDataSource.insertNewUser(user = newUser)

        val retrievedUser = newUser.id?.let { userDataSource.retrieveUserById(id = it) }

        // then
        assertThat(res).isTrue
        if (retrievedUser != null) {
            assertThat(retrievedUser.id).isNotNull
            assertThat(retrievedUser.id).isInstanceOf(UUID::class.java)
            assertThat(retrievedUser.id).isEqualTo(newUser.id)
        } else {
            fail("retrievedUser is null, could not retrieve user by ID")
        }

     }

    @Test
    fun `should throw a NoUserFoundException when trying to retrieve a user that does not exist`() {
        // when
        val userDataSource = MockUserDataSource()

        // then
        assertThatThrownBy {
            userDataSource.retrieveUserById(id = UUID.randomUUID())
        }.isInstanceOf(UserNotFoundException::class.java)
     }
    
    @Test
    fun `should `() {
        //given
        
        
        // when
        
        
        // then
        
        
     }
        
        

}