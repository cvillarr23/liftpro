package com.cvillarreal.LiftPro.service

import com.cvillarreal.LiftPro.datasource.UserDataSource
import com.cvillarreal.liftpro.model.User
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

internal class UserServiceTest {

    private val userDataSource: UserDataSource = mockk(relaxed = true)
    private val userService = UserService(userDataSource)

    @Test
    fun `should call the user data source to get all users`() {
        // when
        userService.getUsers()
        // then
        verify(exactly = 1) { userDataSource.getUsers() }

     }

    @Test
    fun `should return a new UUID when creating a new user`() {
        // given

        every { userDataSource.insertNewUser(any()) } returns true

        // when
        val id = userService.createNewUser(email = "test@test.com", password = "test")

        
        // then
        verify(exactly = 1) { userDataSource.insertNewUser(any()) }
        assertThat(id).isNotNull
        assertThat(id).isInstanceOf(UUID::class.java)
     }
        
        
}
