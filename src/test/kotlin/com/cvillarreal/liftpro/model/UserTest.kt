package com.cvillarreal.liftpro.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

internal class UserTest {
    @Test
    fun `should have a constructor that allows empty ids`() {
        // whenval id = UUID.fromString(idString)
        val user = User(email = "test", password = "test")

        // then
        assertThat(user.id).isNull()
     }

    @Test
    fun `should be able to get email, password and get + set id`() {
        // when
        val id = UUID.randomUUID()
        val user = User(id = id, email = "email", password = "test")

        // then
        assertThat(user.id).isEqualTo(id)
        assertThat(user.email).isEqualTo("email")
        assertThat(user.password).isEqualTo("test")

        val id2 = UUID.randomUUID()
        user.id = id2

        assertThat(user.id).isEqualTo(id2)
     }


}