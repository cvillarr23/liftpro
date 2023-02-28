package com.cvillarreal.liftpro.service

import com.cvillarreal.liftpro.datasource.UserDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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
        
    @Test
    fun `should throw exception if the data source could not create a user`() {
        //given
        every { userDataSource.insertNewUser(any()) } returns false
        // when/then
        assertThrows<Exception> { userService.createNewUser(email = "test", password = "test") }
     }


}
